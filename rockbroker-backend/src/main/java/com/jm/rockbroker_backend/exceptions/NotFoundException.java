package com.jm.rockbroker_backend.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String entity;
    private final String name;
    private final String id;

    public NotFoundException(String entity, String name, String id) {
        super("%s %s with id %s does not exist.".formatted(entity, name, id));
        this.entity = entity;
        this.name = name;
        this.id = id;
    }
}
