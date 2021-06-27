package com.example.msgConsumer.domain.exceptions;

public class UnknownChannelException extends RuntimeException {

    public UnknownChannelException(String msg) {
        super(msg);
    }

    public UnknownChannelException(String msg, Throwable t) {
        super(msg, t);
    }
}
