package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SameTitleException extends RuntimeException{
    public SameTitleException(String title) {
        super(String.format("Blog with title %s already exists ", title));
    }
}
