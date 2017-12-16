package com.f.bigtalk.factory_method;

public class TestFactoryMethod {
    public static void main(String[] args) {
        CreateFactory factory = new DogFactory();
        AnimalBark animal = factory.createAnimal();
        animal.bark();
    }
}
