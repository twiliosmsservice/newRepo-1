package com.blog.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String message;

    public ResourceNotFoundException(String message){
        super(message); // It calls the parent class constructor(RuntimeException < Exception)
                        // RuntimeException calls Exception class constructor.
                        // Exception class constructor calls throwble.
                        // Throwable has the idea how to take this msg and put that in postman response.
    }

}
