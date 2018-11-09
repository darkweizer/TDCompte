package com.company.exception;

public class SimpleRetraitImpossibleException extends RetraitImpossibleException {

    public SimpleRetraitImpossibleException(){
        super("Retrait impossible car vous n'êtes pas autorisé à avoir un découvert !");
    }
}
