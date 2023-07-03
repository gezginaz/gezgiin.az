package com.indice.gezgin.place.dto.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DynamicSearchRequest {

    private String type;
    private String aura;
    private String theme;
    private String architecture;
    private String region;

}
