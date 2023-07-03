package com.indice.gezgin.ads.service.impl;

import com.indice.gezgin.ads.dto.request.IcpAdsJsonRequest;
import com.indice.gezgin.ads.dto.request.IcpAdsRequest;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseAdmin;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseUser;
import com.indice.gezgin.ads.mapper.AdsMapper;
import com.indice.gezgin.ads.model.Ads;
import com.indice.gezgin.ads.repository.AdsRepository;
import com.indice.gezgin.ads.service.AdsService;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.icpcommunication.response.IcpResponseStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdsServiceImpl implements AdsService {

    private final AdsRepository repository;
    public AdsServiceImpl (AdsRepository repository) {
        this.repository = repository;
    }

    @Value("${static.path.ads-image}")
    private String mainFilePath;



    @Override
    public IcpResponseModel<String> addAds(IcpAdsRequest payload, MultipartFile mainImage) throws IOException {
        Ads ads = AdsMapper.INSTANCE.getAdsFromRequest(payload);
        ads.setPictureUrl(saveImages(mainImage));
        ads.setActive(true);
        repository.save(ads);
        return IcpResponseModel.<String>builder()
                .response(null)
                .status(IcpResponseStatus.getSuccess())
                .build();
    }



    @Override
    public IcpResponseModel<String> deleteAds(Long id) {
        Ads ads = repository.getAdsById(id);
        if(ads != null) {
            ads.setActive(false);
            repository.save(ads);
            return IcpResponseModel.<String>builder()
                    .response(null)
                    .status(IcpResponseStatus.getSuccess())
                    .build();
        }
        return IcpResponseModel.<String>builder()
                .response(null)
                .status(IcpResponseStatus.getRequestIsInvalid())
                .build();
    }



    @Override
    public IcpResponseModel<List<IcpAdsResponseUser>> getAllByOffsetUser(int offset) {
        return IcpResponseModel.<List<IcpAdsResponseUser>>builder()
                .response(getUserResponse(repository.findAllActiveAdsWithOffset(offset, 10)))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }



    @Override
    public IcpResponseModel<List<IcpAdsResponseAdmin>> getAllByOffsetAdmin(int offset) {
        return IcpResponseModel.<List<IcpAdsResponseAdmin>>builder()
                .response(getAdminResponse(repository.findAllAdsWithOffset(offset, 10)))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<String> addAdsJson(IcpAdsJsonRequest payload) {
        Ads ads = AdsMapper.INSTANCE.getAdsFromJsonRequest(payload);
        ads.setActive(true);
        repository.save(ads);
        return IcpResponseModel.<String>builder()
                .response(null)
                .status(IcpResponseStatus.getSuccess())
                .build();
    }


    //Utility Methods

    private String saveImages(MultipartFile image) throws IOException {
        image.transferTo(new File(mainFilePath+image.getOriginalFilename()));
        return mainFilePath+image.getOriginalFilename();
    }

    private List<IcpAdsResponseUser> getUserResponse(List<Ads> adss) {
        return adss.stream().map(s->{
            return AdsMapper.INSTANCE.getResponseFromEntityForUser(s);
        }).collect(Collectors.toList());
    }

    private List<IcpAdsResponseAdmin> getAdminResponse(List<Ads> adss) {
        return adss.stream().map(s->{
            IcpAdsResponseAdmin responseAdmin = AdsMapper.INSTANCE.getResponseFromEntity(s);
            responseAdmin.setActive(s.getActive());
            return responseAdmin;
        }).collect(Collectors.toList());
    }

}
