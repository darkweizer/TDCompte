package com.company.commandlinerunner.impl;

import com.company.commandlinerunner.CommandLineRunner;
import com.company.compte.impl.Payant;
import com.company.compte.impl.Premium;
import com.company.compte.impl.Simple;
import com.company.enumeration.CB;

import java.util.HashMap;
import java.util.Map;

public class AddAccountCommandLineRunner extends CommandLineRunner {

    private Map<Integer, CB> cards = new HashMap<>();

    public AddAccountCommandLineRunner(){
        super();
        cards.put(1, CB.CB);
        cards.put(2, CB.VISA);
        cards.put(3, CB.MASTERCARD);
    }

    @Override
    public void execute() {
        double balance = console.printMessageAndGetConsoleNumber("Combien d'argent à l'ouverture?");
        CB cb = null;
        boolean choiceCard = true;
        while(choiceCard) {
            console.printMessage("Quelle type de carte voulez-vous avoir?");
            console.printMessage("1 - CB");
            console.printMessage("2 - Visa");
            cb = cards.get(console.printMessageAndGetConsoleNumber("3 - MasterCard"));
            if(cb != null){
                choiceCard = false;
            } else {
                console.printMessage("Choix incorrect !");
            }
        }

        boolean choiceTypeCompte = true;
        while(choiceTypeCompte) {
            console.printMessage("Quel type de compte voulez-vous créer?");
            console.printMessage("1 - Simple");
            console.printMessage("2 - Payant");
            int choiceCompte = console.printMessageAndGetConsoleNumber("3 - Premium");
            if (choiceCompte == 1) {
                new Simple(balance, cb);
                choiceTypeCompte = false;
            } else if (choiceCompte == 2) {
                new Payant(balance, cb, console.printMessageAndGetConsoleNumber("Définir le découvert autorisé"));
                choiceTypeCompte = false;
            } else if (choiceCompte == 3) {
                new Premium(balance, cb);
                choiceTypeCompte = false;
            }
        }
    }
}
