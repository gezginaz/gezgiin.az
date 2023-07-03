package com.indice.gezgin.report.dto.response;

import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDate;


@Builder
public class IcpReportResponse {

    private Long id;
    private LocalDate createdAt;

    @NonNull
    private Long reportedPlace;
    @NonNull
    private String reason;
    private String details;


    // Constructors
    public IcpReportResponse() {}

    public IcpReportResponse(Long id, LocalDate createdAt, @NonNull Long reportedPlace, @NonNull String reason, String details) {
        this.id = id;
        this.createdAt = createdAt;
        this.reportedPlace = reportedPlace;
        this.reason = reason;
        this.details = details;
    }



    // Getters and Setters
    public Long getReportedPlace() {
        return reportedPlace;
    }

    public void setReportedPlace(Long reportedPlace) {
        this.reportedPlace = reportedPlace;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
