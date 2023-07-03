package com.indice.gezgin.message.service.impl;

import com.indice.gezgin.message.dto.response.IcpMessageResponse;
import com.indice.gezgin.message.mapper.MessageMapper;
import com.indice.gezgin.message.model.Message;
import com.indice.gezgin.message.repository.MessageRepository;
import com.indice.gezgin.message.service.MessageExternalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageExternalServiceImpl implements MessageExternalService {

    private final MessageRepository repository;
    public MessageExternalServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }



    @Override
    public IcpMessageResponse getMessageById(Long id) {
        return MessageMapper.INSTANCE.getMessageResponse(repository.findMessageById(id));
    }


    @Override
    public List<IcpMessageResponse> getAllMessages(int limit, int offset) {
        return repository.findAllMessagesWithOffset(limit, offset).stream().map(MessageMapper.INSTANCE::getMessageResponse).collect(Collectors.toList());
    }


    @Override
    public void deActiveMessage(Long id) {
        Message message = repository.findMessageById(id);
        if(message!=null){
            message.setActive(false);
            repository.save(message);
        }
    }

}
