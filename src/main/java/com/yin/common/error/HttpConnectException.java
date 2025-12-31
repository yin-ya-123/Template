package com.yin.common.error;

public class HttpConnectException extends RuntimeException {

    public HttpConnectException(String message, Throwable cause) {
        super(message, cause);
    }
}
