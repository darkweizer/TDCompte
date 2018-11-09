package com.company.compte.impl;

import com.company.compte.Compte;
import com.company.enumeration.CB;
import com.company.enumeration.TypeCompte;
import com.company.exception.SimpleRetraitImpossibleException;

public class Simple extends Compte {

    public Simple(double solde, CB cb) {
        super(solde, cb, TypeCompte.SIMPLE);
    }

    @Override
    public void retrait(double montant) {
        if((super.getSolde() - montant - super.getTypeCompte().getTauxInteret()) >= 0d) {
            super.retrait(montant);
        } else {
            throw new SimpleRetraitImpossibleException();
        }
    }

    @Override
    public void versement(double montant) {
        super.versement(montant);
    }

    @Override
    public void transfert(double montant, Compte compte) {
        this.retrait(montant);
        super.transfert(montant, compte);
    }
}
