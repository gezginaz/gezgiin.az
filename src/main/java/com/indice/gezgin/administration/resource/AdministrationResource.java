package com.indice.gezgin.administration.resource;


import com.indice.gezgin.administration.service.AdministrationService;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.message.dto.response.IcpMessageResponse;
import com.indice.gezgin.message.model.Message;
import com.indice.gezgin.proposal.dto.response.IcpProposalResponse;
import com.indice.gezgin.report.dto.response.IcpReportResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/administration")
public class AdministrationResource {

    private final AdministrationService service;
    public AdministrationResource(AdministrationService service) {
        this.service = service;
    }



    // Report Service Administration Endpoints
    @GetMapping("/report/get/id")
    public IcpResponseModel<IcpReportResponse> getReportById(@RequestParam("id") Long id){
        return service.getReportById(id);
    }

    @GetMapping("/report/get/all")
    public IcpResponseModel<List<IcpReportResponse>> getAllReports(@RequestParam("limit") int limit, @RequestParam("offset") int offset){
        return service.getAllReports(limit, offset);
    }

    @GetMapping("/report/get/place")
    public IcpResponseModel<List<IcpReportResponse>> getReportsByPlace(@RequestParam("place") Long place){
        return service.getReportsByPlace(place);
    }

    @GetMapping("/report/set/deactive")
    public IcpResponseModel<String> deActivateReport(@RequestParam("id") Long id){
        return service.deActivateReport(id);
    }




    // Proposal Service Administration Endpoints
    @GetMapping("/mekanteklif/deactive")
    public IcpResponseModel<String> deActivateProposal(@RequestParam("id") Long id){
        return service.deActivateProposal(id);
    }

    @GetMapping("/mekanteklif/id")
    public IcpResponseModel<IcpProposalResponse> getProposalById(@RequestParam("id") Long id){
        return service.getProposalById(id);
    }

    @GetMapping("/mekanteklif/all")
    public IcpResponseModel<List<IcpProposalResponse>> getAllProposalsResponses(@RequestParam("limit") int limit, @RequestParam("offset") int offset){
        return service.getAllProposalsResponses(limit, offset);
    }




    // Message Service Administration Endpoints
    @GetMapping("/message/deactive")
    public IcpResponseModel<String> deActivateMessage(@RequestParam("id") Long id){
        return service.deActivateMessage(id);
    }

    @GetMapping("/message/id")
    public IcpResponseModel<IcpMessageResponse> getMessageById(@RequestParam("id") Long id){
        return service.getMessageById(id);
    }

    @GetMapping("/message/all")
    public IcpResponseModel<List<IcpMessageResponse>> getAllMessagesResponses(@RequestParam("limit") int limit, @RequestParam("offset") int offset){
        return service.getAllMessagesResponses(limit, offset);
    }









}
