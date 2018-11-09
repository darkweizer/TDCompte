package com.company.commandlinerunner.impl;

import com.company.commandlinerunner.CommandLineRunner;
import com.company.compte.Compte;

public class DisplayTransationDetailsCommandLineRunner extends CommandLineRunner {
    @Override
    public void execute() {
        int nbTransation = Compte.getNbTransaction();
        if(nbTransation == 0){
            console.printMessage("Il n'y a encore eu aucune transaction !");
            return;
        }
        console.printMessage("Information sur les transactions");
        console.printMessage("\tNombre de transation : " + nbTransation +
                "\n\tSomme perçu par les taxes sur les transactions : " + Compte.getSumTax());
    }
}
