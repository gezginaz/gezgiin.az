package com.indice.gezgin.icpcommunication.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IcpResponseModel<T> {

    private T response;
    private IcpResponseStatus status;

}
