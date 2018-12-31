package com.f.bigtalk.singleton;

public class Singleton {
    private Singleton() {
    }

    private static class Helper {
        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Helper.INSTANCE;
    }
}
