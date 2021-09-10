package com.stc.clinic.exception.device;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException() {
        super("Device Not Found...!");
    }
}