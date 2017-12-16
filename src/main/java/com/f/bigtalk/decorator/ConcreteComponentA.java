package com.f.bigtalk.decorator;

public class ConcreteComponentA extends Decorate {
    @Override
    public void operation() {
        super.operation();
        System.out.println("实现类A 被调用" + this.getClass());
    }
}
