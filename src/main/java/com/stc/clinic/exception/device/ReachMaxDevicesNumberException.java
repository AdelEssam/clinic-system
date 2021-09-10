package com.stc.clinic.exception.device;

public class ReachMaxDevicesNumberException extends RuntimeException {

    public ReachMaxDevicesNumberException() {
        super("Reached Max Number of Devices, Only 10 devices allowed");
    }
}