package com.yin.common.error;

public class HttpTimeoutException extends RuntimeException {

    public HttpTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
