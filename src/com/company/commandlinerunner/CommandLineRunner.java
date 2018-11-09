package com.company.commandlinerunner;

import com.company.Console;

public abstract class CommandLineRunner {

    protected Console console;

    public CommandLineRunner() {
        console = new Console();
    }

    public abstract void execute();
}
