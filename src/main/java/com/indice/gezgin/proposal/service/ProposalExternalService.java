package com.indice.gezgin.proposal.service;

import com.indice.gezgin.proposal.dto.response.IcpProposalResponse;
import com.indice.gezgin.proposal.model.Proposal;

import java.util.List;

public interface ProposalExternalService {

    void deleteProposal(Long id);

    Proposal getProposalById(Long id);

    IcpProposalResponse getProposalResponseById(Long id);

    List<IcpProposalResponse> getAllProposalResponsesWithOffset(int offset, int limit);

    List<IcpProposalResponse> getProposalResponsesByDateWithOffset(String date, int offset, int limit);

}
