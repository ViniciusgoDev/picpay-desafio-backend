package com.desafio_picpay.exceptions;

public class NotPermittedException extends RuntimeException{

    public NotPermittedException(){ super("Usuario sem permissao");}

}
