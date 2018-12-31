package com.f.bigtalk.memento;

public class Player {
    private String name;
    private int age;

    public Player(String foo, int i) {
        name = foo;
        age = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PlayerMemento createState() {
        return new PlayerMemento(name, age);
    }

    public void recovery(PlayerMemento playerMemento) {
        this.name = playerMemento.getName();
        this.age = playerMemento.getAge();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
