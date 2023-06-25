package com.travels.universe.adapters.web.infrastructure;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiErrorMessage {

    private final HttpStatus status;
    private final List<String> errors;

    public ApiErrorMessage(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatus status, String error) {
        this.status = status;
        this.errors = List.of(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }
}
