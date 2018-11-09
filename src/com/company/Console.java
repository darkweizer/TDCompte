package com.company;

import com.company.exception.BadInputException;
import com.company.utils.Tools;

public class Console {

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printOpeningMessage() {
        printMessage("Bienvenue dans la banque !");
    }

    public void printClosingMessage() {
        printMessage("Au revoir et à très bientôt !");
    }

    public String printMessageAndGetConsoleString(String message) {
        printMessage(message);
        return Tools.getConsoleString();
    }

    public void printMenu() {
        printMessage("Que voulez-vous faire?");
        printMessage("1 - Créer un compte");
        printMessage("2 - Effectuer un dépot sur un compte");
        printMessage("3 - Effectuer un retrait sur un compte");
        printMessage("4 - Effectuer un tranfert d'un compte à un autre");
        printMessage("5 - Afficher le détail des comptes");
        printMessage("6 - Afficher le résumé des transactions");
    }

    public Integer printMessageAndGetConsoleNumber(String message) {
        printMessage(message);
        try{
            return Tools.getConsoleNumber();
        } catch (BadInputException e) {
            printMessage("Mauvaise entrer");
            return printMessageAndGetConsoleNumber(message);
        }
    }
}
