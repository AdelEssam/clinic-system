package com.stc.clinic.exception.gateway;

public class InvalidIpFormatException extends RuntimeException {

    public InvalidIpFormatException() {
        super("Invalid IP Address");
    }
}