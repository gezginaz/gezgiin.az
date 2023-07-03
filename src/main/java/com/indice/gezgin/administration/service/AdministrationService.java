package com.indice.gezgin.administration.service;

import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.message.dto.response.IcpMessageResponse;
import com.indice.gezgin.message.model.Message;
import com.indice.gezgin.proposal.dto.response.IcpProposalResponse;
import com.indice.gezgin.report.dto.response.IcpReportResponse;

import java.util.List;

public interface AdministrationService {

    IcpResponseModel<IcpReportResponse> getReportById(Long id);

    IcpResponseModel<List<IcpReportResponse>> getAllReports(int limit, int offset);

    IcpResponseModel<List<IcpReportResponse>> getReportsByPlace(Long place);

    IcpResponseModel<String> deActivateReport(Long id);

    IcpResponseModel<String> deActivateProposal(Long id);

    IcpResponseModel<IcpProposalResponse> getProposalById(Long id);

    IcpResponseModel<List<IcpProposalResponse>> getAllProposalsResponses(int limit, int offset);

    IcpResponseModel<String> deActivateMessage(Long id);

    IcpResponseModel<IcpMessageResponse> getMessageById(Long id);

    IcpResponseModel<List<IcpMessageResponse>> getAllMessagesResponses(int limit, int offset);

}
