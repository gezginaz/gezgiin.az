package com.indice.gezgin.place.resource;

import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.place.dto.request.DynamicSearchRequest;
import com.indice.gezgin.place.dto.response.IcpPlaceResponse;
import com.indice.gezgin.place.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/mekanlar")
public class PlacesResource {

    private final PlaceService service;
    public PlacesResource(PlaceService service){
        this.service = service;
    }


    @PostMapping("/axtar/filter")
    IcpResponseModel<List<IcpPlaceResponse>> searchPlaceWithFilter(@RequestBody DynamicSearchRequest payload,
                                                                   @RequestParam("offset") int offset){
        return service.searchPlaceWithFilter(payload, offset);
    }

    @GetMapping("/image/{id}")
    List<String> getImagesOfPlace(@PathVariable Long id){
        return service.getImagesOfPlace(id);
    }


    @GetMapping("/axtar/ad")
    IcpResponseModel<List<IcpPlaceResponse>> searchPlaceWithName(@RequestParam("ad") String ad,
                                                                 @RequestParam("offset") int offset){
        return service.searchPlaceWithName(ad, offset);
    }

    @GetMapping("/axtar/xususi")
    IcpResponseModel<IcpPlaceResponse> searchPlaceWithId(@RequestParam("id") Long id){
        return service.searchPlaceWithId(id);
    }


}
