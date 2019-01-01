package com.f.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        Dog dog = new Dog();
        InvocationHandler invocationHandler = new MyInvocationHandler<Dog>(dog);
        Animal animal = (Animal) Proxy.newProxyInstance(Dog.class.getClassLoader(), dog.getClass().getInterfaces(), invocationHandler);
        animal.run();
    }
}
