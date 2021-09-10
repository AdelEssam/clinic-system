package com.stc.clinic.exception.gateway;

public class GatewayNotFoundException extends RuntimeException {

    public GatewayNotFoundException() {
        super("Gateway Not Found...!");
    }
}