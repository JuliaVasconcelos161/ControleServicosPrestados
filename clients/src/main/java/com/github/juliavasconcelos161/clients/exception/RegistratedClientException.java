package com.github.juliavasconcelos161.clients.exception;

public class RegistratedClientException extends RuntimeException{

    public RegistratedClientException(String userLogin)
    {
        super("Usuário " + userLogin + " já cadastrado");
    }
}
