package com.company.utils;

import com.company.exception.BadInputException;

import java.util.Scanner;

public class Tools {

    private Tools(){}

    public static String getConsoleString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Integer getConsoleNumber() throws BadInputException {
        try {
            return Integer.parseInt(getConsoleString());
        } catch (NumberFormatException e) {
            throw new BadInputException(e);
        }
    }
}
