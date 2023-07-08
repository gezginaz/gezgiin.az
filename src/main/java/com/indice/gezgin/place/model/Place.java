package com.indice.gezgin.place.model;

import com.indice.gezgin.icpmodel.BaseModel;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;


@Entity
public class Place extends BaseModel {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 500)
    private String mainPictureUrl;
    @Column(nullable = false)
    private String address;
    @Column(length = 400)
    private String description;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String aura;
    @Column(nullable = false)
    private String theme;
    @Column(nullable = false)
    private String architecture;
    @Column(nullable = false)
    private String region;

    private String coordinates;

    private Boolean family;

    private String contact;

    private Boolean openAir;

    private String opens;
    private String closes;

    private Boolean isActive;

    @OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "place_id")
    private Set<PlacePicture> placePictures;

    // Constructors
    public Place() {}

    public Place(Long id, Date createdAt, Date updatedAt, String name, String mainPictureUrl, String address, String description, String type, String aura, String theme, String architecture, String region, String coordinates, Boolean family, String contact, Boolean openAir, String opens, String closes, Boolean isActive, Set<PlacePicture> placePictures) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.mainPictureUrl = mainPictureUrl;
        this.address = address;
        this.description = description;
        this.type = type;
        this.aura = aura;
        this.theme = theme;
        this.architecture = architecture;
        this.region = region;
        this.coordinates = coordinates;
        this.family = family;
        this.contact = contact;
        this.openAir = openAir;
        this.opens = opens;
        this.closes = closes;
        this.isActive = isActive;
        this.placePictures = placePictures;
    }

    public Place(String name, String mainPictureUrl, String address, String description, String type, String aura, String theme, String architecture, String region, String coordinates, Boolean family, String contact, Boolean openAir, String opens, String closes, Boolean isActive, Set<PlacePicture> placePictures) {
        this.name = name;
        this.mainPictureUrl = mainPictureUrl;
        this.address = address;
        this.description = description;
        this.type = type;
        this.aura = aura;
        this.theme = theme;
        this.architecture = architecture;
        this.region = region;
        this.coordinates = coordinates;
        this.family = family;
        this.contact = contact;
        this.openAir = openAir;
        this.opens = opens;
        this.closes = closes;
        this.isActive = isActive;
        this.placePictures = placePictures;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMainPictureUrl() {
        return mainPictureUrl;
    }

    public void setMainPictureUrl(String mainPictureUrl) {
        this.mainPictureUrl = mainPictureUrl;
    }

    public Set<PlacePicture> getPlacePictures() {
        return placePictures;
    }

    public void setPlacePictures(Set<PlacePicture> placePictures) {
        this.placePictures = placePictures;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getFamily() {
        return family;
    }

    public void setFamily(Boolean family) {
        this.family = family;
    }

}
