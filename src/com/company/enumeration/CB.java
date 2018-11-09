package com.company.enumeration;

public enum CB {
    CB(0d),
    VISA(5d),
    MASTERCARD(10d);

    private double prix;

    CB(double prix){
        this.prix = prix;
    }

    public double getPrix(){
        return this.prix;
    }
}
