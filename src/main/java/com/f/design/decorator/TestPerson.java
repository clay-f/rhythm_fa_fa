package com.f.design.decorator;

public class TestPerson {
    public static void main(String[] args) {
        Person foo = new Person("foo");
        Tshirt tshirt = new Tshirt();
        BigTrouser bigTrouser = new BigTrouser();

        bigTrouser.setComponent(foo);
        tshirt.setComponent(bigTrouser);
        tshirt.show();
    }
}
