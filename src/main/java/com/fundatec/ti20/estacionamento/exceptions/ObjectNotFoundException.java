package com.fundatec.ti20.estacionamento.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super("não foi possivel encontrar "  + message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}


