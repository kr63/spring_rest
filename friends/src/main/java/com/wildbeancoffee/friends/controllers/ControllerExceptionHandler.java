package com.wildbeancoffee.friends.controllers;

import com.wildbeancoffee.friends.exceptions.FriendEntityException;
import com.wildbeancoffee.friends.util.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handlerException(FriendEntityException e) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(), System.currentTimeMillis() );

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
