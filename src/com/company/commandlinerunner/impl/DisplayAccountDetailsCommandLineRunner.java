package com.company.commandlinerunner.impl;

import com.company.commandlinerunner.CommandLineRunner;
import com.company.compte.Compte;

import java.util.Map;

public class DisplayAccountDetailsCommandLineRunner extends CommandLineRunner {
    @Override
    public void execute() {
        Map<Integer, Compte> mapComptes = Compte.getAllCompte();
        if(mapComptes.isEmpty()){
            console.printMessage("Il n'y a aucun compte dans la banque !");
            return;
        }
        console.printMessage("Vos comptes");
        for(Compte compte : mapComptes.values()){
            console.printMessage(compte.toString());
        }

        console.printMessage("Total de compte : " + mapComptes.size());
    }
}
