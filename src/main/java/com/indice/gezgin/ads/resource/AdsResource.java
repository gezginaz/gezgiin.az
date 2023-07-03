package com.indice.gezgin.ads.resource;


import com.indice.gezgin.ads.dto.request.IcpAdsJsonRequest;
import com.indice.gezgin.ads.dto.request.IcpAdsRequest;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseAdmin;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseUser;
import com.indice.gezgin.ads.service.AdsService;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdsResource {

    private final AdsService service;
    public AdsResource(AdsService service) {
        this.service = service;
    }



    @PostMapping(value = "/admin/elave")
    public IcpResponseModel<String> addAds(@RequestPart IcpAdsRequest payload, @RequestPart MultipartFile mainImage) throws IOException {
        return service.addAds(payload, mainImage);
    }


    @PostMapping(value = "/admin/json")
    public IcpResponseModel<String> addAdsJson(@RequestBody IcpAdsJsonRequest payload) {
        return service.addAdsJson(payload);
    }


    @GetMapping("/user/hamisi")
    public IcpResponseModel<List<IcpAdsResponseUser>> getAllAdsForUser(@RequestParam("offset") int offset) {
        return service.getAllByOffsetUser(offset);
    }

    @GetMapping("/admin/hamisi")
    public IcpResponseModel<List<IcpAdsResponseAdmin>> getAllAdsForAdmin(@RequestParam("offset") int offset) {
        return service.getAllByOffsetAdmin(offset);
    }


    @GetMapping("/admin/sil")
    public IcpResponseModel<String> deleteAds(@RequestParam("id") Long id) {
        return service.deleteAds(id);
    }


}
