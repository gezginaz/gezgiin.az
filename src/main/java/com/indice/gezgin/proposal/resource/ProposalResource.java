package com.indice.gezgin.proposal.resource;


import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.proposal.dto.request.IcpProposalRequest;

import com.indice.gezgin.proposal.service.ProposalService;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/teklif")
public class ProposalResource {

    private final ProposalService service;
    public ProposalResource(ProposalService service){
        this.service = service;
    }


    @PostMapping("/ver")
    IcpResponseModel<String> giveProposalEndpoint(@RequestBody IcpProposalRequest payload) {
        return service.giveProposal(payload);
    }



}
