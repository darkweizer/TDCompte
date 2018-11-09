package com.company.compte.impl;

import com.company.compte.Compte;
import com.company.enumeration.CB;
import com.company.enumeration.TypeCompte;
import com.company.exception.PayantRetraitImpossibleException;

public class Payant extends Compte {

    private double decouvert;

    public Payant(double solde, CB cb, double decouvert) {
        super(solde - 50, cb, TypeCompte.PAYANT);
        this.decouvert = decouvert;
    }

    @Override
    public void retrait(double montant) {
        if((super.getSolde() - montant - super.getTypeCompte().getTauxInteret()) >= 0d - decouvert) {
            super.retrait(montant);
        } else {
            throw new PayantRetraitImpossibleException(decouvert);
        }
    }

    @Override
    public void versement(double montant) {
        super.versement(montant);
    }

    @Override
    public void transfert(double montant, Compte compte)  {
        this.retrait(montant);
        super.transfert(montant, compte);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tdécouvert autorisé = " + decouvert +
                "\n";
    }
}
