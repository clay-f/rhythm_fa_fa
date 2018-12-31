package com.f.design.memento;

public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("On");
        originator.show();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.setState("off");
        originator.show();
        originator.setMemento(caretaker.getMemento());
        originator.show();

        Player player = new Player("foo", 11);
        CarePlayer carePlayer = new CarePlayer();
        carePlayer.setPlayerMemento(player.createState());
        player.setName("jany");
        System.out.println(player);
        player.recovery(carePlayer.getPlayerMemento());
        System.out.println(player);
    }

}
