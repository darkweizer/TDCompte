package com.company;

import com.company.exception.ApplicationCriticalException;

public class Main {

    public static void main(String[] args) {
        Application app = new Application();

        try{
             app.launch();
        } catch (ApplicationCriticalException e){
            System.out.println(e.getMessage());
        }
    }
}
