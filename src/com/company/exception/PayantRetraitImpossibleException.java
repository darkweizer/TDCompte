package com.company.exception;

public class PayantRetraitImpossibleException extends RetraitImpossibleException {

    public PayantRetraitImpossibleException(double decouvert){
        super("Retrait impossible car vous dépasseriez votre découvert autorisé de " + decouvert + " !");
    }
}
