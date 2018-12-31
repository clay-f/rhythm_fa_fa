package com.f.bigtalk.prototype;

public abstract class Prototype {
    private String id;

    public Prototype(String id) {
        this.id = id;
    }

    public Prototype() {
    }

    public String getId() {
        return id;
    }

    public abstract Prototype cloneSecond() throws CloneNotSupportedException;
}
