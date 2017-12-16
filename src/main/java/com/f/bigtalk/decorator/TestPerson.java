package com.f.bigtalk.decorator;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("foo");

        Clothes clothes = new Clothes();
        clothes.setPerson(person);
        Pants pants = new Pants();
        pants.setPerson(clothes);
        pants.show();
    }
}
