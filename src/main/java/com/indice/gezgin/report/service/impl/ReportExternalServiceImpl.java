package com.indice.gezgin.report.service.impl;


import com.indice.gezgin.report.dto.response.IcpReportResponse;
import com.indice.gezgin.report.mapper.ReportMapper;
import com.indice.gezgin.report.model.Report;
import com.indice.gezgin.report.repository.ReportRepository;
import com.indice.gezgin.report.service.ReportExternalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportExternalServiceImpl implements ReportExternalService {

    private final ReportRepository repository;
    public ReportExternalServiceImpl(ReportRepository repository) {
        this.repository = repository;
    }


    @Override
    public IcpReportResponse getReportById(Long id) {
        return ReportMapper.INSTANCE.getReportResponse(repository.findReportById(id));
    }


    @Override
    public List<IcpReportResponse> getReportsByPlace(Long place) {
        return getResponsesFromEntities(repository.findAllReportsByPlace(place));
    }


    @Override
    public List<IcpReportResponse> getAllReportsWithOffset(int limit, int offset) {
        return getResponsesFromEntities(repository.findAllReportsWithOffset(limit, offset));
    }


    @Override
    public void deActiveReport(Long id) {
        Report report = repository.findReportById(id);
        if(report!=null){
            report.setActive(false);
            repository.save(report);
        }
    }



    // Utility Methods
    List<IcpReportResponse> getResponsesFromEntities(List<Report> entities){
        return entities.stream().map(ReportMapper.INSTANCE::getReportResponse).collect(Collectors.toList());
    }
}
