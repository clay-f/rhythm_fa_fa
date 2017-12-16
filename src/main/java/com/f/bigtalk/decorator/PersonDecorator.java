package com.f.bigtalk.decorator;

public class PersonDecorator extends Person {

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        if (person != null) person.show();
    }
}
