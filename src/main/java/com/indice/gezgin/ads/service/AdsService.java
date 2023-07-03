package com.indice.gezgin.ads.service;

import com.indice.gezgin.ads.dto.request.IcpAdsJsonRequest;
import com.indice.gezgin.ads.dto.request.IcpAdsRequest;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseAdmin;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseUser;
import com.indice.gezgin.ads.model.Ads;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdsService {


    IcpResponseModel<String> addAds(IcpAdsRequest payload, MultipartFile mainImage) throws IOException;

    IcpResponseModel<String> deleteAds (Long id);

    IcpResponseModel<List<IcpAdsResponseUser>> getAllByOffsetUser(int offset);

    IcpResponseModel<List<IcpAdsResponseAdmin>> getAllByOffsetAdmin(int offset);

    IcpResponseModel<String> addAdsJson(IcpAdsJsonRequest payload);
}
