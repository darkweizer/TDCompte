package com.company.commandlinerunner.impl;

import com.company.commandlinerunner.CommandLineRunner;
import com.company.compte.Compte;

import java.util.Map;

public class TransferMoneyCommandLineRunner extends CommandLineRunner {
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
        boolean choiceAccountReceivable = true;
        while(choiceAccountReceivable) {
            Compte accountReceivable = comptes.get(console.printMessageAndGetConsoleNumber("Choisir un compte à débiter"));
            if(accountReceivable != null){
                choiceAccountReceivable = false;
                boolean choiceAccountPayable = true;
                while (choiceAccountPayable) {
                    Compte accountPayable = comptes.get(console.printMessageAndGetConsoleNumber("Choisir un compte à créditer"));
                    if(accountPayable != null) {
                        choiceAccountPayable = false;
                        accountReceivable.transfert(console.printMessageAndGetConsoleNumber("Quelle montant voulez-vous transférer?"), accountPayable);
                    } else {
                        console.printMessage("Choix incorrect !");
                    }
                }
            } else {
                console.printMessage("Choix incorrect !");
            }
        }
    }
}
