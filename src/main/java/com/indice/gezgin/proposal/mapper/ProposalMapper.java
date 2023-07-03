package com.indice.gezgin.proposal.mapper;

import com.indice.gezgin.proposal.dto.request.IcpProposalRequest;
import com.indice.gezgin.proposal.dto.response.IcpProposalResponse;
import com.indice.gezgin.proposal.model.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(componentModel = "spring")
public interface ProposalMapper {

    ProposalMapper INSTANCE = getMapper(ProposalMapper.class);


    @Mapping(source = "placeName", target = "placeName")
    @Mapping(source = "placeAddress", target = "placeAddress")
    @Mapping(source = "placeContact", target = "placeContact")
    @Mapping(source = "placeReason", target = "placeReason")
    Proposal getProposalModel(IcpProposalRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "placeName", target = "placeName")
    @Mapping(source = "placeAddress", target = "placeAddress")
    @Mapping(source = "placeContact", target = "placeContact")
    @Mapping(source = "placeReason", target = "placeReason")
    IcpProposalResponse getProposalResponse(Proposal proposal);

}
