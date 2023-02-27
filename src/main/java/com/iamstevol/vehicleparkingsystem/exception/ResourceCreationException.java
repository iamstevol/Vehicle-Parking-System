package com.iamstevol.vehicleparkingsystem.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResourceCreationException extends RuntimeException{
    protected String message;

    public ResourceCreationException(String message) {
        super(message);
        this.message = message;
    }
}
