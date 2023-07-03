package com.indice.gezgin.ads.dto.request;

import lombok.Builder;

import java.time.LocalDate;


@Builder
public class IcpAdsJsonRequest {

    private String companyName;
    private String linkedUrl;
    private LocalDate deadLine;
    private String pictureUrl;


    // Constructors
    public IcpAdsJsonRequest() {}

    public IcpAdsJsonRequest(String companyName, String linkedUrl, LocalDate deadLine, String pictureUrl) {
        this.companyName = companyName;
        this.linkedUrl = linkedUrl;
        this.deadLine = deadLine;
        this.pictureUrl = pictureUrl;
    }


    //Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkedUrl() {
        return linkedUrl;
    }

    public void setLinkedUrl(String linkedUrl) {
        this.linkedUrl = linkedUrl;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
