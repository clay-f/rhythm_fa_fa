package com.f.design.decorator;

public class Finery extends Person {
    protected Person component;

    public void setComponent(Person component) {
        this.component = component;
    }

    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
