package com.jm.rockbroker_backend.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private String timestamp;
}
