package com.indice.gezgin.user.service.impl;

import com.indice.gezgin.icpcommunication.request.IcpJustJwt;
import com.indice.gezgin.icpcommunication.request.IcpSingleData;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.icpcommunication.response.IcpResponseStatus;
import com.indice.gezgin.security.jwt.JwtProvider;
import com.indice.gezgin.user.dto.request.IcpEditUser;
import com.indice.gezgin.user.dto.request.IcpEditUserPass;
import com.indice.gezgin.user.dto.response.IcpUserResponse;
import com.indice.gezgin.user.model.AppUser;
import com.indice.gezgin.user.repository.UserRepository;
import com.indice.gezgin.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final JwtProvider jwtProvider;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(JwtProvider jwtProvider, UserRepository repository, PasswordEncoder passwordEncoder){
        this.jwtProvider=jwtProvider;
        this.repository=repository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public IcpResponseModel<IcpUserResponse> getAccountInformationForUser(String username, IcpJustJwt data) {
        return null;
    }

    @Override
    public IcpResponseModel<IcpUserResponse> getAccountInformationForGuest(String username) {
        return null;
    }


    @Override
    public IcpResponseModel<IcpUserResponse> editUser(String username, IcpEditUser data) {
        return null;
    }



    @Override
    public IcpResponseModel<String> editUserPassword(String username, IcpEditUserPass epEditUserPassword) {
        AppUser user = repository.findAppUserByUsername(username);
        if(user == null || !isJwtBelongToUser(user.getUserId(), epEditUserPassword.getJwt()) || !user.isNotLocked())
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getRequestIsInvalid())
                    .build();
        if(passwordEncoder.matches(epEditUserPassword.getCurrentPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(epEditUserPassword.getNewPassword()));
            saveUser(user);
        }
        else
            return IcpResponseModel.<String>builder()
                    .response("Password is invalid!")
                    .status(IcpResponseStatus.getPassIsWrong())
                    .build();
        return IcpResponseModel.<String>builder()
                .response("Success")
                .status(IcpResponseStatus.getSuccess())
                .build();
    }


    @Override
    public IcpResponseModel<String> editUserPrivacy(String username, IcpSingleData data) {
        AppUser user = repository.findAppUserByUsername(username);
        if(user == null || !isJwtBelongToUser(user.getUserId(), data.getJwt()) || !checkPrivacyRequest(data.getData()) || !user.isNotLocked())
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getRequestIsInvalid())
                    .build();
        user.setPrivacy(data.getData());
        saveUser(user);
        return IcpResponseModel.<String>builder()
                .response("Success")
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public Boolean isUsernameExists(String username) {
        if(repository.findAppUserByUsername(username)==null)
            return false;
        else
            return true;
    }

    @Override
    public IcpResponseModel<String> editUserGender(IcpJustJwt payload, String gender) {
        AppUser user = repository.findAppUserByUsername(jwtProvider.getSubject(payload.getJwt()));
        if(user == null || !user.isNotLocked() || !(gender.equals("kisi") && !gender.equals("qadin")))
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getRequestIsInvalid())
                    .build();
        user.setGender(gender);
        repository.save(user);
        return IcpResponseModel.<String>builder()
                .response("Success")
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<String> editUserProfilePicture(IcpJustJwt payload) {
        return IcpResponseModel.<String>builder()
                .response("This method does not exists. Code it!")
                .status(IcpResponseStatus.get404())
                .build();
    }




    //==================================================================================================================
    /**
     * @Target: Burdan sonraki metodlar User Service ucun yazilmis yardimci metodlardir.
     * @Comment: Bunlarin xaricle baglanditi yoxdur / olmamalidir.
     * @Comment: Bunlar sadece oxunurlugu artirmaq ucundur
     * */
    public AppUser getUserByUserId(String userId) {
        return repository.findAppUserByUserId(userId);
    }

    public AppUser findAppUserByUserId(String userId) {
        return repository.findAppUserByUserId(userId);
    }

    public void saveUser(AppUser user){
        repository.save(user);
    }

    public AppUser findUserByUsername(String username) {
        return repository.findAppUserByUsername(username);
    }

    public AppUser findAppUserByEmail(String email) {
        return repository.findAppUserByEmail(email);
    }

    private boolean isJwtBelongToUser(String userId, String jwt){
        return jwtProvider.getSubject(jwt).equals(userId);
    }


    private boolean checkPrivacyRequest(String data) {
        return data.equals("private") || data.equals("open");
    }



}