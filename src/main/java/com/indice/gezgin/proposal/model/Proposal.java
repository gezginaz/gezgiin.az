package com.indice.gezgin.proposal.model;

import com.indice.gezgin.icpmodel.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.ToString;

import java.util.Date;


@Entity
@Builder
@ToString
public class Proposal extends BaseModel {

    @Column(nullable = false)
    private String placeName;

    @Column(nullable = false)
    private String placeAddress;

    private String placeContact;

    @Column(nullable = false, length = 255)
    private String placeReason;

    private Boolean isActive;


    // Constructors
    public Proposal(Long id, Date createdAt, Date updatedAt, String placeName, String placeAddress, String placeContact, String placeReason, Boolean isActive) {
        super(id, createdAt, updatedAt);
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.placeContact = placeContact;
        this.placeReason = placeReason;
        this.isActive = isActive;
    }

    public Proposal(String placeName, String placeAddress, String placeContact, String placeReason, Boolean isActive) {
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.placeContact = placeContact;
        this.placeReason = placeReason;
        this.isActive = isActive;
    }

    public Proposal() {}



    //Getters and Setters
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public String getPlaceContact() {
        return placeContact;
    }

    public void setPlaceContact(String placeContact) {
        this.placeContact = placeContact;
    }

    public String getPlaceReason() {
        return placeReason;
    }

    public void setPlaceReason(String placeReason) {
        this.placeReason = placeReason;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
