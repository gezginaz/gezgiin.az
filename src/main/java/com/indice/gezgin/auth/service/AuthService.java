package com.indice.gezgin.auth.service;

import com.indice.gezgin.auth.dto.IcpSignIn;
import com.indice.gezgin.auth.dto.IcpSignUpAsAdmin;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;

public interface AuthService {

    IcpResponseModel<String> signUpAdmin(IcpSignUpAsAdmin request, String code);

    IcpResponseModel<String> signInUser(IcpSignIn request);

}

