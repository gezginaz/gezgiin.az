package com.indice.gezgin.proposal.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IcpProposalRequest {

    private String placeName;
    private String placeAddress;
    private String placeContact;
    private String placeReason;


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
}
