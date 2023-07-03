package com.indice.gezgin.report.service.impl;

import com.indice.gezgin.icpcommunication.response.IcpResponseINDEX_;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.report.dto.request.IcpReportRequest;
import com.indice.gezgin.report.mapper.ReportMapper;
import com.indice.gezgin.report.model.Report;
import com.indice.gezgin.report.repository.ReportRepository;
import com.indice.gezgin.report.service.ReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository repository;
    public ReportServiceImpl(ReportRepository repository){
        this.repository = repository;
    }


    @Override
    public IcpResponseModel<String> reportPlace(IcpReportRequest payload, Long id) {
        Report report = ReportMapper.INSTANCE.getReportEntity(payload);
        report.setReportedPlace(id);
        repository.save(report);
        return IcpResponseINDEX_.getSuccessResponse();
    }

}
