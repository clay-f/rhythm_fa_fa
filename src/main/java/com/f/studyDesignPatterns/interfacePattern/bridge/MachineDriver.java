package com.f.studyDesignPatterns.interfacePattern.bridge;

public interface MachineDriver {
    void startMachine();

    void stopMachine();

    void startProcess();

    void stopProcess();

    void conveyIn();

    void conveyOut();
}
