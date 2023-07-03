package com.indice.gezgin.administration.service.impl;


import com.indice.gezgin.administration.service.AdministrationService;
import com.indice.gezgin.icpcommunication.response.IcpResponseINDEX_;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.icpcommunication.response.IcpResponseStatus;
import com.indice.gezgin.message.dto.response.IcpMessageResponse;
import com.indice.gezgin.message.service.MessageExternalService;
import com.indice.gezgin.proposal.dto.response.IcpProposalResponse;
import com.indice.gezgin.proposal.service.ProposalExternalService;
import com.indice.gezgin.report.dto.response.IcpReportResponse;
import com.indice.gezgin.report.service.ReportExternalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrationServiceImpl implements AdministrationService {

    private final ReportExternalService rService;
    private final ProposalExternalService pService;
    private final MessageExternalService mService;
    public AdministrationServiceImpl(ReportExternalService rService, ProposalExternalService pService, MessageExternalService mService){
        this.rService = rService;
        this.pService = pService;
        this.mService = mService;
    }



    // Report Service Administration Methods
    @Override
    public IcpResponseModel<IcpReportResponse> getReportById(Long id) {
        return IcpResponseModel.<IcpReportResponse>builder()
                .response(rService.getReportById(id))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<List<IcpReportResponse>> getAllReports(int limit, int offset) {
        return IcpResponseModel.<List<IcpReportResponse>>builder()
                .response(rService.getAllReportsWithOffset(offset, limit))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<List<IcpReportResponse>> getReportsByPlace(Long place) {
        return IcpResponseModel.<List<IcpReportResponse>>builder()
                .response(rService.getReportsByPlace(place))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<String> deActivateReport(Long id) {
        rService.deActiveReport(id);
        return IcpResponseINDEX_.getSuccessResponse();
    }




    // Proposal Service Administration Methods
    @Override
    public IcpResponseModel<String> deActivateProposal(Long id) {
        pService.deleteProposal(id);
        return IcpResponseINDEX_.getSuccessResponse();
    }

    @Override
    public IcpResponseModel<IcpProposalResponse> getProposalById(Long id) {
        return  IcpResponseModel.<IcpProposalResponse>builder()
                .response(pService.getProposalResponseById(id))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<List<IcpProposalResponse>> getAllProposalsResponses(int limit, int offset) {
        return IcpResponseModel.<List<IcpProposalResponse>>builder()
                .response(pService.getAllProposalResponsesWithOffset(offset, limit))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }




    // Message Service Administration Methods
    @Override
    public IcpResponseModel<String> deActivateMessage(Long id) {
        mService.deActiveMessage(id);
        return IcpResponseINDEX_.getSuccessResponse();
    }

    @Override
    public IcpResponseModel<IcpMessageResponse> getMessageById(Long id) {
        return IcpResponseModel.<IcpMessageResponse>builder()
                .response(mService.getMessageById(id))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

    @Override
    public IcpResponseModel<List<IcpMessageResponse>> getAllMessagesResponses(int limit, int offset) {
        return IcpResponseModel.<List<IcpMessageResponse>>builder()
                .response(mService.getAllMessages(offset, limit))
                .status(IcpResponseStatus.getSuccess())
                .build();
    }






    // Utility Methods
}
