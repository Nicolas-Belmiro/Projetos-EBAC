package com.finalizacao.java.vendas.online.exception;

public class BadRequestException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1126880403554249359L;

    public BadRequestException(String message) {
        super(message);
    }

}