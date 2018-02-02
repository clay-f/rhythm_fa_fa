package com.f.bigtalk.prototype;

public class ConcretePrototype1 extends Prototype {

    public ConcretePrototype1() {

    }

    public ConcretePrototype1(String id) {
        super(id);
    }


    public Prototype cloneSecond() throws CloneNotSupportedException {
            return (Prototype) this.clone();
    }
}
