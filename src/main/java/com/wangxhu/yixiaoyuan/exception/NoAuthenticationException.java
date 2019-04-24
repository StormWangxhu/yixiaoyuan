package com.wangxhu.yixiaoyuan.exception;

public class NoAuthenticationException extends Exception {
    public NoAuthenticationException() {
    }

    public NoAuthenticationException(String message) {
        super(message);
    }
}