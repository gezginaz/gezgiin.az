package com.indice.gezgin.place.service.impl;


import com.indice.gezgin.icpcommunication.response.IcpResponseINDEX_;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.icpcommunication.response.IcpResponseStatus;
import com.indice.gezgin.place.dto.request.DynamicSearchRequest;
import com.indice.gezgin.place.dto.request.IcpPlaceRequest;
import com.indice.gezgin.place.dto.request.IcpPlacerRequestWithImage;
import com.indice.gezgin.place.dto.response.IcpPlaceResponse;
import com.indice.gezgin.place.mapper.PlaceMapper;
import com.indice.gezgin.place.model.Place;
import com.indice.gezgin.place.model.PlacePicture;
import com.indice.gezgin.place.repository.PlacePictureRepository;
import com.indice.gezgin.place.repository.PlaceRepository;
import com.indice.gezgin.place.service.PlaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;
    public PlaceServiceImpl(PlaceRepository repository){
        this.repository = repository;
    }

    @Value("${static.path.place-image}")
    private String mainFilePath;


    @Override
    public IcpResponseModel<String> addNewPlace(IcpPlaceRequest payload, MultipartFile mainImage, MultipartFile imageOne,
                                                MultipartFile imageTwo, MultipartFile imageThree) throws IOException {
        mainImage.transferTo(new File(mainFilePath+mainImage.getOriginalFilename()));
        Set<PlacePicture> pictures = new HashSet<>();
        if(!imageOne.getOriginalFilename().isEmpty())
            pictures.add(savePlaceImages(imageOne));
        if(!imageTwo.getOriginalFilename().isEmpty())
            pictures.add(savePlaceImages(imageTwo));
        if(!imageThree.getOriginalFilename().isEmpty())
            pictures.add(savePlaceImages(imageThree));
        Place place = PlaceMapper.INSTANCE.getPlaceEntity(payload);
        place.setActive(true);
        place.setPlacePictures(pictures);
        place.setMainPictureUrl(mainFilePath+mainImage.getOriginalFilename());
        repository.save(place);
        return IcpResponseINDEX_.getSuccessResponse();
    }



    @Override
    public IcpResponseModel<String> editExistedPlace(IcpPlaceRequest payload, Long id) {
        Place place = repository.findPlaceByID(id);
        if(place!=null){
            PlaceMapper.INSTANCE.TransferRequestToPlace(payload, place);
            repository.save(place);
        }
        return IcpResponseINDEX_.getSuccessResponse();
    }


    @Override
    public IcpResponseModel<String> deleteExistedPlace(Long id) {
        Place place = repository.findPlaceByID(id);
        if(place!=null)
            repository.delete(place);
        return IcpResponseINDEX_.getSuccessResponse();
    }


    @Override
    public IcpResponseModel<List<IcpPlaceResponse>> searchPlaceWithFilter(DynamicSearchRequest payload, int offset) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(payload.toString());
        return IcpResponseModel.<List<IcpPlaceResponse>>builder()
                .response(getResponsesFromEntities(repository.dynamicSearch(payload, 10, offset)))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }


    @Override
    public IcpResponseModel<List<IcpPlaceResponse>> searchPlaceWithName(String ad, int offset) {
        return IcpResponseModel.<List<IcpPlaceResponse>>builder()
                .response(getResponsesFromEntities(repository.findPlaceByNameWithOffset(ad, offset, 10)))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }



    @Override
    public IcpResponseModel<IcpPlaceResponse> searchPlaceWithId(Long id) {
        Place place = repository.findPlaceByID(id);
        if(place == null)
            return IcpResponseModel.<IcpPlaceResponse>builder()
                    .response(null)
                    .status(IcpResponseStatus.getRequestIsInvalid())
                    .build();
        IcpPlaceResponse response = PlaceMapper.INSTANCE.getPlaceResponse(place);
        response.setPictures(place.getPlacePictures().stream().map(s-> {
            return s.getPictureUrl();
        }).collect(Collectors.toList()));
        return IcpResponseModel.<IcpPlaceResponse>builder()
                .response(response)
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<String> addPlaceWithJson(IcpPlacerRequestWithImage payload) {
        Place place = PlaceMapper.INSTANCE.getPlaceFromWithJsonRequest(payload);
        repository.save(place);
        return IcpResponseModel.<String>builder()
                .response(null)
                .status(IcpResponseStatus.getSuccess())
                .build();
    }


    @Override
    public List<String> getImagesOfPlace(Long id) {
        return null;
    }




    // Utility Methods
    List<IcpPlaceResponse> getResponsesFromEntities(List<Place> places){
        return places.stream().map(s->{
                    IcpPlaceResponse r = PlaceMapper.INSTANCE.getPlaceResponse(s);
                    r.setPictures(getImagesOfPlace(s));
                    return r;
                }
        ).collect(Collectors.toList());
    }


    List<String> getImagesOfPlace(Place place) {
        return place.getPlacePictures().stream().map(PlacePicture::getPictureUrl).collect(Collectors.toList());
    }


    private PlacePicture savePlaceImages(MultipartFile image) throws IOException {
        image.transferTo(new File(mainFilePath+image.getOriginalFilename()));
        return PlacePicture.builder()
                .pictureUrl(mainFilePath+image.getOriginalFilename())
                .build();
    }
}
