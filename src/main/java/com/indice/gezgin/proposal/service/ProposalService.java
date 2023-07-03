package com.indice.gezgin.proposal.service;

import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.proposal.dto.request.IcpProposalRequest;
import com.indice.gezgin.proposal.model.Proposal;

public interface ProposalService {
    IcpResponseModel<String> giveProposal(IcpProposalRequest payload);
}
