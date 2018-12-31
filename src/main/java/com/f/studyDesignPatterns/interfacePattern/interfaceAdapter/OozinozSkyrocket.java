package com.f.studyDesignPatterns.interfacePattern.interfaceAdapter;

public class OozinozSkyrocket extends Skyrocket {

    Rocket rocket;

    public OozinozSkyrocket() {}

    public  OozinozSkyrocket(Rocket r) {

    }

    double getMass() {
        return 0;
    }

    double getThurst() {
        return 0;
    }
}
