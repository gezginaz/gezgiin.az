package com.indice.gezgin.report.model;

import com.indice.gezgin.icpmodel.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Report extends BaseModel {


    @Column(nullable = false, updatable = false)
    private Long reportedPlace;

    @Column(nullable = false, length = 100)
    private String reason;

    @Column(nullable = false, length = 255)
    private String details;

    private Boolean isActive;


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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
