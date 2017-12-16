package com.f.bigtalk.decorator;

public abstract class Decorate implements Component {
    private Component component;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Decorate() {
    }

    public Decorate(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null) component.operation();
    }
}
