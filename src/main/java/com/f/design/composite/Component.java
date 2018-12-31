package com.f.design.composite;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);
    public abstract void remove(Component c);
    public abstract void display(int depth);
}
