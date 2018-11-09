package com.company;

import com.company.commandlinerunner.CommandLineRunner;
import com.company.commandlinerunner.impl.*;
import com.company.exception.RetraitImpossibleException;

import java.util.HashMap;
import java.util.Map;

public class Application {

    private Console console;
    private Boolean isLaunch = true;
    private Boolean isFirstLoop = true;

    private Map<Integer, CommandLineRunner> commands = new HashMap<>();

    public Application() {
        commands.put(1, new AddAccountCommandLineRunner());
        commands.put(2, new AddMoneyCommandLineRunner());
        commands.put(3, new TakeMoneyCommandLineRunner());
        commands.put(4, new TransferMoneyCommandLineRunner());
        commands.put(5, new DisplayAccountDetailsCommandLineRunner());
        commands.put(6, new DisplayTransationDetailsCommandLineRunner());
    }

    public void launch(){
        console = new Console();

        console.printOpeningMessage();

        while (isLaunch){
            int choice;
            if(shouldPrintMenu()){
                console.printMenu();
                choice = console.printMessageAndGetConsoleNumber("Que voulez-vous faire ?");
            } else {
                executeQuitApplication();
                break;
            }

            try {
                CommandLineRunner commandLineRunner = commands.get(choice);
                if(commandLineRunner != null){
                    commandLineRunner.execute();
                } else {
                    console.printMessage("Choix incorrect !");
                }
            } catch (RetraitImpossibleException e) {
                console.printMessage("Erreur : " + e.getMessage());
            }
        }

        console.printClosingMessage();
    }

    private boolean shouldPrintMenu() {
        if(isFirstLoop){
            isFirstLoop = false;
            return true;
        }
        String reponse = console.printMessageAndGetConsoleString("Voulez-vous effectuer une autre opération? (O/N)");
        return reponse.equalsIgnoreCase("O");
    }

    private void executeQuitApplication() {
        isLaunch = false;
    }
}
