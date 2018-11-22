package com.wildbeancoffee.friends.exceptions;

public class FriendEntityException extends RuntimeException {

    public FriendEntityException() {
        super();
    }

    public FriendEntityException(String message) {
        super(message);
    }

    public FriendEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public FriendEntityException(Throwable cause) {
        super(cause);
    }

    protected FriendEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
