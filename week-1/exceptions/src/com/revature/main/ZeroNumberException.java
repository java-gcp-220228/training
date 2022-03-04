package com.revature.main;

public class ZeroNumberException extends Exception {

    public ZeroNumberException() {
    }

    public ZeroNumberException(String message) {
        super(message);
    }

    public ZeroNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZeroNumberException(Throwable cause) {
        super(cause);
    }

    public ZeroNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
