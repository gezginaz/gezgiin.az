package com.indice.gezgin.place.model;

import com.indice.gezgin.icpmodel.BaseModel;
import jakarta.persistence.Entity;
import lombok.Builder;

import java.util.Date;

@Entity
@Builder
public class PlacePicture extends BaseModel {

    private String pictureUrl;


    // Constructors
    public PlacePicture() {}

    public PlacePicture(Long id, Date createdAt, Date updatedAt, String pictureUrl) {
        super(id, createdAt, updatedAt);
        this.pictureUrl = pictureUrl;
    }

    public PlacePicture(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }


    // Getters and Setters
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
