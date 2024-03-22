package com.exploremore.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private int statusCode;
    private HttpStatus status;
    private String message;

    public ErrorResponse(int statuscode, HttpStatus status, String message) {
        this.statusCode = statuscode;
        this.status = status;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ErrorResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "statusCode=" + statusCode +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
