package com.f.bigtalk.decorator;

public class ConcreteComponentB extends Decorate {
    public void operation() {
        super.operation();
        System.out.println("具体实现类 B 被调用" + this.getClass());
    }
}
