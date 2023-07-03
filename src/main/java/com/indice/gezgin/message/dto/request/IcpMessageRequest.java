package com.indice.gezgin.message.dto.request;


import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IcpMessageRequest {

    @NonNull
    private String type;

    @NonNull
    private String fullNameOfSender;

    private String contactOfSender;

    @NonNull
    private String message;


}
