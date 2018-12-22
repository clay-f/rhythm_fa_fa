package com.f.java.concurrent.example.toast;

public class Toast {
    public enum Status {
        DRY, BUTTERED, JAMED
    }

    private Status status = Status.DRY;

    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Toast " + id + " : " + status;
    }

}
