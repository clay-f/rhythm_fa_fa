package com.f.design.composite;


public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("can't add to leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("can't remove from a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + "\t" + name);
    }
}
