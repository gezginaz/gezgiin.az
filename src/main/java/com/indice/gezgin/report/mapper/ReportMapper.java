package com.indice.gezgin.report.mapper;

import com.indice.gezgin.report.dto.request.IcpReportRequest;
import com.indice.gezgin.report.dto.response.IcpReportResponse;
import com.indice.gezgin.report.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;


@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportMapper INSTANCE = getMapper(ReportMapper.class);



    Report getReportEntity(IcpReportRequest request);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "createdAt", target = "createdAt")
    IcpReportResponse getReportResponse(Report report);


}
