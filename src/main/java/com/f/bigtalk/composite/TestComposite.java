package com.f.bigtalk.composite;

public class TestComposite {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("leaf a"));
        root.add(new Leaf("leaf b"));

        Composite composite = new Composite(("composite1"));
        composite.add(new Leaf("composite1 b"));
        composite.add(new Leaf("composite1 c"));

        root.add(composite);

        Composite composite1 = new Composite("composite2");
        composite1.add(new Leaf("composite2 b"));
        composite.add(new Leaf("composite2 c"));

        Composite composite2 = new Composite("composite2-1");
        composite2.add(new Leaf("composite2-1 a"));

        composite1.add(composite2);

        Composite composite3 = new Composite("composite2-1-1");
        composite3.add(new Leaf("composite2-1-1 a"));
        composite3.add(new Composite("composite2-1-1-1"));


        composite2.add(composite3);
        root.add(composite1);
        root.add(new Leaf("leaf c"));
        Leaf leaf = new Leaf("leaf d");
        root.add(leaf);
        root.remove(leaf);
        root.display(1);
    }
}
