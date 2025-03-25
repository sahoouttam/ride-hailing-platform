package com.ride.hailing.platform.exception;

public class DriversNotFoundException extends RuntimeException {
    public DriversNotFoundException(String message) {
        super(message);
    }
}
