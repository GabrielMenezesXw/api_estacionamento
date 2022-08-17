package com.fundatec.ti20.estacionamento.exceptions;

public class ConflitoException extends RuntimeException {

    public ConflitoException(String message) {
        super("impossivel criar, pois tal objeto entra em conflito com um já existente," +
                "poir favor rever informações" + message);
    }

    public ConflitoException(String message, Throwable cause) {
        super(message, cause);
    }
}
