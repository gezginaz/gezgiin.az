package com.indice.gezgin.message.resource;


import com.indice.gezgin.icpcommunication.response.IcpResponseModel;
import com.indice.gezgin.message.dto.request.IcpMessageRequest;
import com.indice.gezgin.message.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bildiris")
public class MessageResource {

    private final MessageService service;
    public MessageResource(MessageService service){
        this.service = service;
    }


    @PostMapping("/gonder")
    IcpResponseModel<String> sendMessage(@RequestBody IcpMessageRequest payload){
        return service.sendMessage(payload);
    }

}
