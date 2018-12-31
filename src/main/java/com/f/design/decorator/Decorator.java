package com.f.design.decorator;

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
