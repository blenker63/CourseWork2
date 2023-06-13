package com.prosky.coursework2.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceedingNumberQuestionsException extends RuntimeException {
    public ExceedingNumberQuestionsException(String massage) {
        super(massage);
    }
}
