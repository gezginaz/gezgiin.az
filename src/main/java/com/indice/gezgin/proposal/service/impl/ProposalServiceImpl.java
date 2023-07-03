package com.indice.gezgin.proposal.service.impl;


import com.indice.gezgin.icpcommunication.response.IcpResponseINDEX_;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.proposal.dto.request.IcpProposalRequest;
import com.indice.gezgin.proposal.mapper.ProposalMapper;
import com.indice.gezgin.proposal.model.Proposal;
import com.indice.gezgin.proposal.repository.ProposalRepository;
import com.indice.gezgin.proposal.service.ProposalService;
import org.springframework.stereotype.Service;


@Service
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository repository;
    public ProposalServiceImpl(ProposalRepository repository) {
        this.repository = repository;
    }


    @Override
    public IcpResponseModel<String> giveProposal(IcpProposalRequest payload) {
        Proposal proposal = ProposalMapper.INSTANCE.getProposalModel(payload);
        proposal.setActive(true);
        repository.save(proposal);
        return IcpResponseINDEX_.getSuccessResponse();
    }


}
