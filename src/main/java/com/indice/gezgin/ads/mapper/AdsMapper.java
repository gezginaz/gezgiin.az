package com.indice.gezgin.ads.mapper;


import com.indice.gezgin.ads.dto.request.IcpAdsJsonRequest;
import com.indice.gezgin.ads.dto.request.IcpAdsRequest;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseAdmin;
import com.indice.gezgin.ads.dto.response.IcpAdsResponseUser;
import com.indice.gezgin.ads.model.Ads;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(componentModel = "spring")
public interface AdsMapper {

    AdsMapper INSTANCE = getMapper(AdsMapper.class);



    Ads getAdsFromRequest(IcpAdsRequest request);


    Ads getAdsFromJsonRequest(IcpAdsJsonRequest request);

    IcpAdsResponseAdmin getResponseFromEntity(Ads ads);


    IcpAdsResponseUser getResponseFromEntityForUser(Ads ads);


}
