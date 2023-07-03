package com.indice.gezgin.user.resource;

import com.indice.gezgin.icpcommunication.request.IcpJustJwt;
import com.indice.gezgin.icpcommunication.request.IcpSingleData;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.user.dto.request.IcpEditUser;
import com.indice.gezgin.user.dto.response.IcpUserResponse;
import com.indice.gezgin.user.dto.request.IcpEditUserPass;
import com.indice.gezgin.user.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/@")
public class UserResource {

    private final UserServiceImpl service;
    public UserResource(UserServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/{username}")
    public IcpResponseModel<IcpUserResponse> getUserInformationForGuest(@PathVariable String username) {
        return service.getAccountInformationForGuest(username);
    }


    @PostMapping("/{username}")
    public IcpResponseModel<IcpUserResponse> getUserInformationForUser(@PathVariable String username, @RequestBody IcpJustJwt data) {
        return service.getAccountInformationForUser(username, data);
    }

    @PostMapping("/{username}/edit")
    public IcpResponseModel<IcpUserResponse> editUser(@PathVariable String username, @RequestBody IcpEditUser data) {
        return service.editUser(username, data);
    }

    @PostMapping("/{username}/pass")
    public IcpResponseModel<String> editUserPass(@PathVariable String username, @RequestBody IcpEditUserPass password) {
        return service.editUserPassword(username, password);
    }

    @PostMapping("/{username}/set/gender")
    public IcpResponseModel<String> editUserGender(@PathVariable String username, @RequestParam("gender") String gender, @RequestBody IcpJustJwt payload) {
        return service.editUserGender(payload, gender);
    }

    @PostMapping("/{username}/set/profilepicture")
    public IcpResponseModel<String> editUserProfilePicture(@PathVariable String username, @RequestBody IcpJustJwt payload) {
        return service.editUserProfilePicture(payload);
    }


    @PostMapping("/{username}/privacy")
    public IcpResponseModel<String> editUserPrivacy(@PathVariable String username, @RequestBody IcpSingleData privacy) {
        return service.editUserPrivacy(username, privacy);
    }

    @GetMapping("/doesexists")
    public Boolean doesUsernameExists(@RequestParam("username") String username) {
        return service.isUsernameExists(username);
    }
}

