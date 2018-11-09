package com.company.exception;

public class ApplicationCriticalException extends RuntimeException {
    public ApplicationCriticalException(Throwable cause) {
        super("Une erreur est survenu sur l'application et celle-ci va fermer..." + cause.getMessage(), cause);
    }
}
