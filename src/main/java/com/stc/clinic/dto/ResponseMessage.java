package com.stc.clinic.dto;

import lombok.Data;

@Data
public class ResponseMessage {

    public ResponseMessage(String message) {
        this.message = message;
    }

    private String message;
}
