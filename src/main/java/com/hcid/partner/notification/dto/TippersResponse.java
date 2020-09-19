package com.hcid.partner.notification.dto;


import lombok.Data;




@Data
public class TippersResponse {
    
    private String auth;

    
    private String token;

    
    private Long timestamp;

    
    private String code;

    
    private Object object;

   
    private String description;

    private String severity;

    private String message;

    public Long getTimestamp() {
        timestamp = System.currentTimeMillis();
        return timestamp;
    }
}
