package com.talk.threadtalk.Exceptions;

public class UsuarioException extends Exception {

    public UsuarioException(String mensaje) {
        super(mensaje);
    }

    public UsuarioException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
