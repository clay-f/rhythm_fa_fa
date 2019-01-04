package com.f.design.decorator;

interface Component {
    void operator();
}

public abstract class Decorator implements Component {
    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operator() {
        if (component != null) {
            component.operator();
        }
    }
}

class ComponentA extends Decorator {
    @Override
    public void operator() {
        super.operator();
        System.out.println("component A");
    }
}

class ComponentB extends Decorator {
    @Override
    public void operator() {
        super.operator();
        System.out.println("Component B");
    }
}

class ComponentC extends Decorator {
    @Override
    public void operator() {
        super.operator();
        System.out.println("Component C");
    }
}