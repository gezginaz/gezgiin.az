package com.indice.gezgin.message.service.impl;

import com.indice.gezgin.constants.MessageConstants;
import com.indice.gezgin.icpcommunication.response.IcpResponseINDEX_;
import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.message.dto.request.IcpMessageRequest;
import com.indice.gezgin.message.mapper.MessageMapper;
import com.indice.gezgin.message.model.Message;
import com.indice.gezgin.message.repository.MessageRepository;
import com.indice.gezgin.message.service.MessageService;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;
    public MessageServiceImpl(MessageRepository repository){
        this.repository = repository;
    }


    @Override
    public IcpResponseModel<String> sendMessage(IcpMessageRequest payload) {
        System.out.println("DIRECT SERVICE =============================================================================");
        System.out.println("sendMessage -> payload: " + payload.toString());
        if(!validateMessageRequest(payload.getType()))
            return IcpResponseINDEX_.getInvalidRequestResponse();
        Message message = MessageMapper.INSTANCE.getMessageEntity(payload);
        System.out.println("entity Message = " + message.toString());
        message.setActive(true);
        repository.save(message);
        System.out.println("DIRECT SERVICE -----------------------------------------------------------------------------");
        return IcpResponseINDEX_.getSuccessResponse();
    }



    // Utility Methods
    boolean validateMessageRequest(String type) {
        System.out.println("validateMessageRequest -> Parameter: " + type);
        return MessageConstants.getMessageTypes().stream().anyMatch(type::equals);
    }

}
