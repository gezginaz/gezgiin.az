package com.indice.gezgin.report.dto.request;


import lombok.Builder;
import lombok.NonNull;

@Builder
public class IcpReportRequest {

    @NonNull
    private String reason;
    private String details;


    // Constructors
    public IcpReportRequest() {}

    public IcpReportRequest(@NonNull String reason, String details) {
        this.reason = reason;
        this.details = details;
    }


    // Getters and Setters
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
}
