package com.manors.parkview.practicalunittesting.exception;

public class InvalidRequestException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = -343519768334908258L;

    public InvalidRequestException(String message, Throwable err) {
        super(message, err);
    }
}
