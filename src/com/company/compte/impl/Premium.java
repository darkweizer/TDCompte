package com.company.compte.impl;

import com.company.compte.Compte;
import com.company.enumeration.CB;
import com.company.enumeration.TypeCompte;

public class Premium extends Compte {

    public Premium(double solde, CB cb) {
        super(solde - 150, cb, TypeCompte.PREMIUM);
    }

    @Override
    public void retrait(double montant) {
        super.retrait(montant);
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
