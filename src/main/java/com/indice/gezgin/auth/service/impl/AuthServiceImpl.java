package com.indice.gezgin.auth.service.impl;

import com.indice.gezgin.auth.dto.IcpSignIn;
import com.indice.gezgin.auth.dto.IcpSignUpAsAdmin;
import com.indice.gezgin.auth.service.AuthService;
import com.indice.gezgin.authority.model.Authority;
import com.indice.gezgin.authority.repository.AuthorityRepository;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.icpcommunication.response.IcpResponseStatus;
import com.indice.gezgin.security.jwt.JwtProvider;
import com.indice.gezgin.security.model.AppUserPrincipal;
import com.indice.gezgin.user.mapper.UserMapper;
import com.indice.gezgin.user.model.AppUser;
import com.indice.gezgin.user.service.impl.UserExternalServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.indice.gezgin.auth.constants.SignConstantsCode.AUTH_SERVICE_INTERNAL_ERROR;
import static com.indice.gezgin.auth.constants.SignConstantsMessage.*;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserExternalServiceImpl userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authRepository;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    public AuthServiceImpl(UserExternalServiceImpl userService, PasswordEncoder passwordEncoder, AuthorityRepository authRepository,
                           JwtProvider jwtProvider, AuthenticationManager authenticationManager){
        this.userService=userService;
        this.passwordEncoder=passwordEncoder;
        this.authRepository=authRepository;
        this.jwtProvider=jwtProvider;
        this.authenticationManager=authenticationManager;
    }



    @Value("${auth.admin.register-code}")
    private String registerCode;



    @Override
    public IcpResponseModel<String> signUpAdmin(IcpSignUpAsAdmin request, String code) {
        if(!isRequestUnique(request.getUsername(), request.getPhone())){
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.builder().message(USERNAME_ALREADY_EXISTS).code(AUTH_SERVICE_INTERNAL_ERROR).build())
                    .build();
        }
        if(!code.equals(registerCode))
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getRequestIsInvalid())
                    .build();
        AppUser user = UserMapper.INSTANCE.getUserFromSignAsAdmin(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        setRoleToUser(user, ADMIN);
        user.setUserId(generateUserId());
        user.setNotLocked(true);
        user.setRole("ADMIN");
        user.setActive(true);
        signInTransactions(request.getUsername(), request.getPhone());
        userService.saveUser(user);
        AppUserPrincipal principal = new AppUserPrincipal(user);
        String token = jwtProvider.generateJWT(principal);
        return IcpResponseModel.<String>builder()
                .response(token)
                .status(IcpResponseStatus.getSuccess())
                .build();
    }



    @Override
    @Transactional
    public IcpResponseModel<String> signInUser(IcpSignIn request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

        }catch (Exception ex){
            System.out.println(ex);
//            throw new CustomException(StatusMessage.USERNAME_OR_PASSWORD_IS_INVALID, StatusCode.USERNAME_OR_PASSWORD_IS_INVALID);
            return IcpResponseModel.<String>builder()
                    .response("Invalid Username or Password")
                    .status(IcpResponseStatus.getPassIsWrong())
                    .build();
        }
        AppUserPrincipal principal = getPrincipal(request.getUsername());
        if(!principal.isEnabled())
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getAccountIsNotEnabled())
                    .build();
        if(principal.banned())
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getAccountBanned())
                    .build();
        if(!principal.isAccountNonLocked())
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getAccountIsUnderLookup())
                    .build();
        String response = jwtProvider.generateJWT(principal);
        return IcpResponseModel.<String>builder()
                .response(response)
                .status(IcpResponseStatus.getSuccess())
                .build();
    }



    // Utility Methods ################################################################################################

    // USER qeydiyyatdan kecerken bir defeye ozel cagirilir.
    // Meqsed qeydiyyatdan kecen USERe DBdan elaqesiz bir ID vermekdir
    // Burdaki meqsed ise USERin DB IDsinin tehlukesizlik meqsedi ile FrontEnd e bildirmemekdir.
    private String generateUserId(){
        return DateTimeFormatter.ISO_INSTANT.format(LocalDateTime.now().toInstant(ZoneOffset.UTC)).substring(2)
                .replace("T", "").replace("-", "").replace(":","").replace(".","");
    }


    // USER obyektinden UserDetails obyekti almaq ucun
    private AppUserPrincipal getPrincipal(String username){
        return new AppUserPrincipal(userService.findUserFromLogin(username));
    }





    //Qeydiyyat isteyinde gelen 'username' in uygun olub olmadigini yoxlayiriq
    private boolean isRequestUnique(String username, String phone) {
        System.out.println(userService.findUserByUsername(username));
        return userService.findUserByUsername(username)==null && userService.findAppUserByPhone(phone)==null;
    }


    //Qeydiyyat isteyinde gelen 'username' in ve ya nomrenin tesdiqlenmemis olub olmadigini yoxlayiriq
    private void signInTransactions(String username, String phone) {
        AppUser userByUsername = userService.findAppUserByUsernameActiveFALSE(username);
        if(userByUsername != null){
            userService.deleteUser(userByUsername);
        }
        AppUser userByPhone = userService.findAppUserByPhoneActiveFALSE(phone);
        if(userByPhone != null){
            userService.deleteUser(userByPhone);
        }
    }


    //Gonderilen 'User'e gonderilen adda 'Role'u DBdan cekib verir
    private void setRoleToUser(AppUser user, String role) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authRepository.findByAuthority(role));
        user.setAuthorities(authorities);
    }



}
