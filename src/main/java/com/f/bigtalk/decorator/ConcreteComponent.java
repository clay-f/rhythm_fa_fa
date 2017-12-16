package com.f.bigtalk.decorator;

public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("具体实现类被调用, 类名是: " + this.getClass());
    }
}
