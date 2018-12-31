package com.f.design.command;

public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void exe() {
        command.executeCommand();
    }
}
