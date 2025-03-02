package com.progressoft.clustereddatawarehouse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedIdException extends RuntimeException {

    public DuplicatedIdException(String message) {
        super(message);
    }
}
