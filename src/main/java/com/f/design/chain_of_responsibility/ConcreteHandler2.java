package com.f.design.chain_of_responsibility;

public class ConcreteHandler2 extends Handler {
    @Override
    public void handlerRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("handler request 2");
        } else if (handler != null) {
            handler.handlerRequest(request);
        }
    }
}
