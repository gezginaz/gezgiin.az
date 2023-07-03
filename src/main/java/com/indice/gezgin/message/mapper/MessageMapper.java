package com.indice.gezgin.message.mapper;

import com.indice.gezgin.message.dto.request.IcpMessageRequest;
import com.indice.gezgin.message.dto.response.IcpMessageResponse;
import com.indice.gezgin.message.model.Message;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;


@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = getMapper(MessageMapper.class);


    Message getMessageEntity(IcpMessageRequest payload);

    IcpMessageResponse getMessageResponse(Message message);


}
