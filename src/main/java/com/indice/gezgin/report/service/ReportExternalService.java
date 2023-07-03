package com.indice.gezgin.report.service;


import com.indice.gezgin.report.dto.response.IcpReportResponse;

import java.util.List;

public interface ReportExternalService {

    IcpReportResponse getReportById(Long id);

    List<IcpReportResponse> getReportsByPlace(Long place);

    List<IcpReportResponse> getAllReportsWithOffset(int limit, int offset);

    void deActiveReport(Long id);

}
