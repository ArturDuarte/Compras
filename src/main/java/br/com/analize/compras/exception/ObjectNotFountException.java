package br.com.analize.compras.exception;

public class ObjectNotFountException extends RuntimeException{

    public ObjectNotFountException(String msg) {
        super(msg);
    }

    public ObjectNotFountException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
