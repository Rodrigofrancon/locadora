package br.com.locadora.services.exceptions;

public class IntegridadeDB extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public IntegridadeDB(String msg) {
        super(msg);
    }
}
