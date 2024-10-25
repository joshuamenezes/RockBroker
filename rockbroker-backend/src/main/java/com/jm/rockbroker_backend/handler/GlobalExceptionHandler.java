package com.jm.rockbroker_backend.handler;

import com.jm.rockbroker_backend.exceptions.ResourceNotFoundException;
import com.jm.rockbroker_backend.factories.ErrorResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        // Log exception with context information
        logger.error("Exception occurred: {}, Request Details: {}", ex.getMessage(), request.getDescription(false), ex);

        ErrorResponse err = ErrorResponseFactory.createErrorResponse("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        // Log specific exception
        logger.error("Invalid argument: {}, Request Details: {}", ex.getMessage(), request.getDescription(false), ex);
        ErrorResponse err = ErrorResponseFactory.createErrorResponse("Invalid argument(s) in request body.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        logger.error("Invalid argument: {}, Request Details: {}", ex.getMessage(), request.getDescription(false), ex);
        ErrorResponse err = ErrorResponseFactory.createErrorResponse("No %s with the given id could be found".formatted(ex.getEntity()), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        logger.error("Data Integrity Violation: {}, Request Details: {}", ex.getMessage(), request.getDescription(false));
        ErrorResponse err = ErrorResponseFactory.createErrorResponse("Data uniqueness constraints violated.", HttpStatus.CONFLICT);
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }
}
