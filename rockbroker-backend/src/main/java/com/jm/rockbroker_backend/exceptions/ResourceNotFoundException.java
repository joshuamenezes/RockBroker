package com.jm.rockbroker_backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final String DEFAULT_ERROR_MESSAGE = "%s with id %d does not exist.";
    private final String entity;
    private final Long id;

    public ResourceNotFoundException(String entity, Long id) {
        super(DEFAULT_ERROR_MESSAGE.formatted(entity, id));
        this.entity = entity;
        this.id = id;
    }

    public ResourceNotFoundException(String entity, Long id, String customMessage) {
        super(customMessage);
        this.entity = entity;
        this.id = id;
    }
}
