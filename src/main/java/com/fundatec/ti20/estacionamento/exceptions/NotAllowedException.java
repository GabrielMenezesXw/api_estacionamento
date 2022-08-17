package com.fundatec.ti20.estacionamento.exceptions;


public class NotAllowedException extends RuntimeException{

    public NotAllowedException(String message) {
        super("metodo não permitido, pois "+ message);
    }

    public NotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }
}
