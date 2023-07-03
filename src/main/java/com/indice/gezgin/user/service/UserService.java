package com.indice.gezgin.user.service;

import com.indice.gezgin.icpcommunication.request.IcpJustJwt;
import com.indice.gezgin.icpcommunication.request.IcpSingleData;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.user.dto.request.IcpEditUser;
import com.indice.gezgin.user.dto.request.IcpEditUserPass;
import com.indice.gezgin.user.dto.response.IcpUserResponse;

public interface UserService {


    IcpResponseModel<IcpUserResponse> getAccountInformationForUser(String username, IcpJustJwt data);

    IcpResponseModel<IcpUserResponse> getAccountInformationForGuest(String username);

    IcpResponseModel<IcpUserResponse> editUser(String username, IcpEditUser data);

    IcpResponseModel<String> editUserPassword(String username, IcpEditUserPass epEditUserPassword);

    IcpResponseModel<String> editUserPrivacy(String username, IcpSingleData data);

    Boolean isUsernameExists(String username);

    IcpResponseModel<String> editUserGender(IcpJustJwt payload, String gender);

    IcpResponseModel<String> editUserProfilePicture(IcpJustJwt payload);

}