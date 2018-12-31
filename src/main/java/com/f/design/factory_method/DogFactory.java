package com.f.design.factory_method;

public class DogFactory implements CreateFactory {
    @Override
    public AnimalBark createAnimal() {
        return new Dog();
    }
}
