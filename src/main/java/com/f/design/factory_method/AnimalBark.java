package com.f.design.factory_method;

public abstract class AnimalBark {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void bark();
}
