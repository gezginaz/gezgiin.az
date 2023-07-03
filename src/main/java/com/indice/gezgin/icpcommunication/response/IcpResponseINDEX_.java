package com.indice.gezgin.icpcommunication.response;

public class IcpResponseINDEX_ {


    public static IcpResponseModel<String> getInvalidRequestResponse(){
        return IcpResponseModel.<String>builder()
                .response(null)
                .status(IcpResponseStatus.getRequestIsInvalid())
                .build();
    }


    public static IcpResponseModel<String> getSuccessResponse(){
        return IcpResponseModel.<String>builder()
                .response(null)
                .status(IcpResponseStatus.getSuccess())
                .build();
    }

}
