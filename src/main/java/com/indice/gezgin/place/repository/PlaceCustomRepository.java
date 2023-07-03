package com.indice.gezgin.place.repository;


import com.indice.gezgin.place.dto.request.DynamicSearchRequest;
import com.indice.gezgin.place.model.Place;

import java.util.List;



public interface PlaceCustomRepository {

    List<Place> dynamicSearch(DynamicSearchRequest payload, int limit, int offset);

}
