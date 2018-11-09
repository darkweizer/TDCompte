package com.company.compte;

import com.company.enumeration.CB;
import com.company.enumeration.TypeCompte;

import java.util.HashMap;
import java.util.Map;

public abstract class Compte {

    private static int nbCompte = 0;
    private static Map<Integer, Compte> allCompte = new HashMap<>();
    private static double sumTax = 0;
    private static int nbTransaction = 0;

    private double solde;
    private final int code;
    private CB cb;
    private TypeCompte typeCompte;

    protected Compte(double solde, CB cb, TypeCompte typeCompte) {
        this.solde = solde - cb.getPrix();
        ++Compte.nbCompte;
        this.code = Compte.nbCompte;
        this.cb = cb;
        this.typeCompte = typeCompte;
        allCompte.put(this.code, this);
    }

    /**
     * Permet de retirer de l'argent à un compte
     * @param montant à retirer
     */
    public void retrait(double montant){
        this.solde -= montant + this.typeCompte.getTauxInteret();
        Compte.setSumTax(Compte.getSumTax() + this.typeCompte.getTauxInteret());
        Compte.setNbTransaction(Compte.getNbTransaction() + 1);
    }


    /**
     * Permet d'ajouter de l'argent à un compte
     * @param montant à ajouter
     */
    public void versement(double montant){
        this.solde += montant - this.typeCompte.getTauxInteret();
        Compte.setSumTax(Compte.getSumTax() + this.typeCompte.getTauxInteret());
        Compte.setNbTransaction(Compte.getNbTransaction() + 1);
    }

    /**
     * Permet de transférer de l'argent d'un compte à un autre
     * @param montant de la transaction
     * @param compte à créditer
     */
    public void transfert(double montant, Compte compte){
        compte.versement(montant);
    }

    @Override
    public String toString() {
        return "Compte " + code +
                " :\n\tsolde = " + solde +
                "\n\ttype de carte = " + cb +
                "\n\ttype de compte = " + typeCompte +
                "\n";
    }

    public static Map<Integer, Compte> getAllCompte() {
        return allCompte;
    }

    public double getSolde() {
        return solde;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public static double getSumTax() {
        return sumTax;
    }

    public static void setSumTax(double sumTax) {
        Compte.sumTax = sumTax;
    }

    public static int getNbTransaction() {
        return nbTransaction;
    }

    public static void setNbTransaction(int nbTransaction) {
        Compte.nbTransaction = nbTransaction;
    }
}
