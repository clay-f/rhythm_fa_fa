package com.f.bigtalk.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public void display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + "\t" + name);
        for (Component item
                : components) {
            item.display(depth + 1);
        }
    }
}
