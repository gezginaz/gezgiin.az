package com.indice.gezgin.report.service;

import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.report.dto.request.IcpReportRequest;

public interface ReportService {
    IcpResponseModel<String> reportPlace(IcpReportRequest payload, Long id);
}
