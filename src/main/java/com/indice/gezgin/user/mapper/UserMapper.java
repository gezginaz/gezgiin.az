package com.indice.gezgin.user.mapper;

import com.indice.gezgin.auth.dto.IcpSignUpAsAdmin;
import com.indice.gezgin.user.dto.request.IcpEditUser;
import com.indice.gezgin.user.dto.request.IcpEditUserPass;
import com.indice.gezgin.user.dto.response.IcpUserResponse;
import com.indice.gezgin.user.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = getMapper(UserMapper.class);



    IcpUserResponse getSelfAccountFromUser(AppUser appUser);


    @Mapping(source = "bio", target = "bio")
    @Mapping(source = "profilePictureUrl", target = "profilePictureUrl")
    @Mapping(source = "howManyUserStared", target = "howManyUserStared")
    @Mapping(target = "relation", expression = "java(\"self\")")
    IcpUserResponse getEpAccountWithEmailFromUser(AppUser appUser);

    @Mapping(source = "bio", target = "bio")
    @Mapping(target = "email", expression = "java(null)")
    @Mapping(target = "address", expression = "java(null)")
    @Mapping(target = "phone", expression = "java(null)")
    @Mapping(source = "profilePictureUrl", target = "profilePictureUrl")
    @Mapping(source = "howManyUserStared", target = "howManyUserStared")
    IcpUserResponse getEpAccountWithoutEmailFromUser(AppUser appUser);





    void transferEditRequestToUser(IcpEditUser icpEditUser, @MappingTarget AppUser appUser);


    @Mapping(source = "newPassword", target = "password")
    void transferPasswordRequestToUser(IcpEditUserPass userPassword, @MappingTarget AppUser appUser);




    AppUser getUserFromSignAsAdmin(IcpSignUpAsAdmin icpSignUpAsAdmin);


}

