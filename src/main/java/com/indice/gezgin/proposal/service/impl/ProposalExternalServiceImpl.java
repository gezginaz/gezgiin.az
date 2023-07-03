package com.indice.gezgin.proposal.service.impl;

import com.indice.gezgin.proposal.dto.response.IcpProposalResponse;
import com.indice.gezgin.proposal.mapper.ProposalMapper;
import com.indice.gezgin.proposal.model.Proposal;
import com.indice.gezgin.proposal.repository.ProposalRepository;
import com.indice.gezgin.proposal.service.ProposalExternalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProposalExternalServiceImpl implements ProposalExternalService {

    private final ProposalRepository repository;
    public ProposalExternalServiceImpl(ProposalRepository repository) {
        this.repository = repository;
    }


    @Override
    public void deleteProposal(Long id) {
        Proposal proposal = repository.findProposalById(id);
        if(proposal != null){
            proposal.setActive(false);
            repository.save(proposal);
        }

    }

    @Override
    public Proposal getProposalById(Long id) {
        return repository.findProposalById(id);
    }


    @Override
    public IcpProposalResponse getProposalResponseById(Long id) {
        return ProposalMapper.INSTANCE.getProposalResponse(repository.findProposalById(id));
    }


    @Override
    public List<IcpProposalResponse> getAllProposalResponsesWithOffset(int offset, int limit) {
        return repository.findAllProposalsWithOffset(offset, limit).stream().map(
                ProposalMapper.INSTANCE::getProposalResponse
        ).collect(Collectors.toList());
    }


    @Override
    public List<IcpProposalResponse> getProposalResponsesByDateWithOffset(String date, int offset, int limit) {
        if(!checkIfDateValid(date))
            return null;
        return repository.findProposalByDateWithOffset(date, offset, limit).stream().map(
                ProposalMapper.INSTANCE::getProposalResponse
        ).collect(Collectors.toList());
    }


    // Utility Methods
    private boolean checkIfDateValid(String date){
        String[] parts = date.split("-");
        if(parts.length > 3)
            return false;
        else if (parts[0].length() != 4)
            return false;
        else if (parts[1].length() != 2)
            return false;
        else return parts[2].length() == 2;
    }

}
