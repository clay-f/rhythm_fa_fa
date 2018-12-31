package com.f.bigtalk.factory_method;

public class CatFactory implements CreateFactory {
    @Override
    public AnimalBark createAnimal() {
        return new Cat();
    }
}
