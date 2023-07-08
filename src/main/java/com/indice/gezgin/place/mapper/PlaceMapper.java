package com.indice.gezgin.place.mapper;


import com.indice.gezgin.place.dto.request.IcpPlaceRequest;
import com.indice.gezgin.place.dto.request.IcpPlacerRequestWithImage;
import com.indice.gezgin.place.dto.response.IcpPlaceResponse;
import com.indice.gezgin.place.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    PlaceMapper INSTANCE = getMapper(PlaceMapper.class);



    @Mapping(target = "mainPictureUrl", ignore = true)
    Place getPlaceEntity(IcpPlaceRequest payload);

    @Mapping(target = "active", expression = "java(true)")
    @Mapping(source = "contact", target = "contact")
    Place getPlaceFromWithJsonRequest (IcpPlacerRequestWithImage request);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "coordinates", target = "coordinates")
    @Mapping(source = "contact", target = "contact")
    IcpPlaceResponse getPlaceResponse(Place place);

    void TransferRequestToPlace(IcpPlaceRequest payload, @MappingTarget Place place);
    //Salam
}
