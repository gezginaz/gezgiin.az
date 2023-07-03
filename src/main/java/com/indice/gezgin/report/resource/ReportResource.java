package com.indice.gezgin.report.resource;


import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.report.dto.request.IcpReportRequest;
import com.indice.gezgin.report.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sikayet")
public class ReportResource {

    private final ReportService service;
    public ReportResource (ReportService service) {
        this.service = service;
    }

    @PostMapping("/et")
    IcpResponseModel<String> reportPlace(@RequestBody IcpReportRequest payload, @RequestParam("id") Long id) {
        return service.reportPlace(payload, id);
    }

}
