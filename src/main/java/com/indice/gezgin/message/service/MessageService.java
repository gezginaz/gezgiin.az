package com.indice.gezgin.message.service;

import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.message.dto.request.IcpMessageRequest;

public interface MessageService {
    IcpResponseModel<String> sendMessage(IcpMessageRequest payload);
}
