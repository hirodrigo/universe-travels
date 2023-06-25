package com.travels.universe.application.exception;

public class TravelPlanNotFoundException extends RuntimeException {

    public TravelPlanNotFoundException(String message) {
        super(message);
    }
}
