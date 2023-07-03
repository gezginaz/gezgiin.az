package com.indice.gezgin.place.resource;

import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.place.dto.request.IcpPlaceRequest;
import com.indice.gezgin.place.dto.request.IcpPlacerRequestWithImage;
import com.indice.gezgin.place.service.PlaceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/mekan")
public class PlaceResource {

    private final PlaceService service;
    public PlaceResource(PlaceService service) {
        this.service = service;
    }


    @PostMapping(value = "/elave")
    public IcpResponseModel<String> addNewPlace(@RequestPart IcpPlaceRequest payload, @RequestPart MultipartFile mainImage,
                                                @RequestPart MultipartFile imageOne, @RequestPart MultipartFile imageTwo,
                                                @RequestPart MultipartFile imageThree) throws IOException {
        return service.addNewPlace(payload, mainImage, imageOne, imageTwo, imageThree);
    }



    @PostMapping("/deyis")
    public IcpResponseModel<String> editExistedPlace(@RequestBody IcpPlaceRequest payload, @RequestParam("id") Long id) {
        return service.editExistedPlace(payload, id);
    }


    @GetMapping("/sil")
    public IcpResponseModel<String> deleteExistedPlace(@RequestParam("id") Long id) {
        return service.deleteExistedPlace(id);
    }


    @PostMapping("/json")
    public IcpResponseModel<String> addPlaceWithJson(@RequestBody IcpPlacerRequestWithImage payload) {
        return service.addPlaceWithJson(payload);
    }

}
