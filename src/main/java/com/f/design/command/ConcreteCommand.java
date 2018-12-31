package com.f.design.command;

public class ConcreteCommand extends Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void executeCommand() {
        receiver.exe();
    }
}
