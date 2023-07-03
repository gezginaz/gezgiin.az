package com.indice.gezgin.message.service;


import com.indice.gezgin.message.dto.response.IcpMessageResponse;

import java.util.List;

public interface MessageExternalService {

    IcpMessageResponse getMessageById(Long id);

    List<IcpMessageResponse> getAllMessages(int limit, int offset);

    void deActiveMessage(Long id);

}
