package com.indice.gezgin.place.service;


import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.place.dto.request.DynamicSearchRequest;
import com.indice.gezgin.place.dto.request.IcpPlaceRequest;
import com.indice.gezgin.place.dto.request.IcpPlacerRequestWithImage;
import com.indice.gezgin.place.dto.response.IcpPlaceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlaceService {
    IcpResponseModel<String> addNewPlace(IcpPlaceRequest payload, MultipartFile mainImage, MultipartFile imageOne,
                                         MultipartFile imageTwo, MultipartFile imageThree) throws IOException;

    IcpResponseModel<String> editExistedPlace(IcpPlaceRequest payload, Long id);

    IcpResponseModel<String> deleteExistedPlace(Long id);

    IcpResponseModel<List<IcpPlaceResponse>> searchPlaceWithFilter(DynamicSearchRequest payload, int offset);

    IcpResponseModel<List<IcpPlaceResponse>> searchPlaceWithName(String ad, int offset);

    List<String> getImagesOfPlace(Long id);

    IcpResponseModel<IcpPlaceResponse> searchPlaceWithId(Long id);

    IcpResponseModel<String> addPlaceWithJson(IcpPlacerRequestWithImage payload);
}
