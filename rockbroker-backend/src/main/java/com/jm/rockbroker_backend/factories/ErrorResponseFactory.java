package com.jm.rockbroker_backend.factories;

import com.jm.rockbroker_backend.handler.ErrorResponse;
import com.jm.rockbroker_backend.util.TimeUtils;
import org.springframework.http.HttpStatus;

public class ErrorResponseFactory {

    // Factory method to create an ErrorResponse with given message and status
    public static ErrorResponse createErrorResponse(String message, HttpStatus status) {
        return new ErrorResponse(message, status, TimeUtils.getCurrentFormattedTime());
    }
}
