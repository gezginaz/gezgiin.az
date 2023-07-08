package com.indice.gezgin.place.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IcpPlaceResponse {

    private Long id;
    //Salam

    private String name;
    private String mainPictureUrl;
    private String address;
    private String description;
    private String type;
    private String aura;
    private String theme;
    private String architecture;
    private String region;
    private Boolean openAir;
    private String opens;
    private String closes;
    private String coordinates;
    private String contact;
    private List<String> pictures;
    private Boolean family;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainPictureUrl() {
        return mainPictureUrl;
    }

    public void setMainPictureUrl(String mainPictureUrl) {
        this.mainPictureUrl = mainPictureUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAura() {
        return aura;
    }

    public void setAura(String aura) {
        this.aura = aura;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getOpenAir() {
        return openAir;
    }

    public void setOpenAir(Boolean openAir) {
        this.openAir = openAir;
    }

    public String getOpens() {
        return opens;
    }

    public void setOpens(String opens) {
        this.opens = opens;
    }

    public String getCloses() {
        return closes;
    }

    public void setCloses(String closes) {
        this.closes = closes;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getFamily() {
        return family;
    }

    public void setFamily(Boolean family) {
        this.family = family;
    }
}
