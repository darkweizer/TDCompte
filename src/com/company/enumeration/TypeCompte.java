package com.company.enumeration;

public enum TypeCompte {
    SIMPLE(5d),
    PAYANT(1d),
    PREMIUM(0d);

    private double tauxInteret;

    TypeCompte(double tauxInteret){
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret(){
        return this.tauxInteret;
    }
}
