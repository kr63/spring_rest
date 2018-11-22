package com.wildbeancoffee.friends.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FriendNotFoundException extends RuntimeException {

    public FriendNotFoundException(String message) {
        this(message, null);
    }

    public FriendNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
