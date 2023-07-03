package com.indice.gezgin.message.dto.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IcpMessageResponse {

    private Long id;

    private LocalDate createdAt;

    private String type;

    private String fullNameOfSender;

    private String contactOfSender;

    private String message;

}
