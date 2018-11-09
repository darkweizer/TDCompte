package com.company.commandlinerunner.impl;

import com.company.commandlinerunner.CommandLineRunner;
import com.company.compte.Compte;

import java.util.Map;

public class AddMoneyCommandLineRunner extends CommandLineRunner {
    @Override
    public void execute() {
        Map<Integer, Compte> comptes = Compte.getAllCompte();
        if(comptes.isEmpty()){
            console.printMessage("Il n'y a aucun compte dans la banque !");
            return;
        }
        console.printMessage("Liste des comptes");
        int cpt = 0;
        StringBuilder row = new StringBuilder();
        for(Integer number : comptes.keySet()){
            row.append(Integer.toString(number));
            cpt++;
            if(cpt == 10) {
                console.printMessage(row.toString());
                cpt = 0;
                row.setLength(0);
            }
            row.append("\t");
        }
        if(cpt != 0) {
            console.printMessage(row.toString());
        }
        boolean choiceAccount = true;
        while(choiceAccount) {
            Compte compte = comptes.get(console.printMessageAndGetConsoleNumber("Choisir un compte"));
            if(compte != null){
                choiceAccount = false;
                compte.versement(console.printMessageAndGetConsoleNumber("Quelle montant voulez-vous ajouter?"));
            } else {
                console.printMessage("Choix incorrect !");
            }
        }
    }
}
