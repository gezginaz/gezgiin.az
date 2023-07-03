package com.indice.gezgin.auth.resource;

import com.indice.gezgin.auth.dto.IcpSignIn;
import com.indice.gezgin.auth.dto.IcpSignUpAsAdmin;
import com.indice.gezgin.auth.service.AuthService;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DefaultResource {

    private AuthService service;
    public DefaultResource(AuthService service){
        this.service=service;
    }

    @PostMapping(value = "/45/40/merkez/login", produces = MediaType.APPLICATION_JSON_VALUE)
    IcpResponseModel<String> signIn(@RequestBody IcpSignIn request){
        return service.signInUser(request);
    }


    @PostMapping(value = "/45/40/merkez/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    IcpResponseModel<String> signUpAdmin(@RequestBody IcpSignUpAsAdmin request, @RequestParam("code") String code){
        return service.signUpAdmin(request, code);
    }



    @GetMapping("/user/0")
    String userAuthTest(){
        return "Access Granted";
    }

    @GetMapping("/admin/0")
    String adminAuthTest(){
        return "Access Granted";
    }

}
