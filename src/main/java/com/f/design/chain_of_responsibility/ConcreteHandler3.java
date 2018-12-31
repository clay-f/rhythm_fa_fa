package com.f.design.chain_of_responsibility;

public class ConcreteHandler3 extends Handler {
    @Override
    public void handlerRequest(int request) {
        if (request > 20 && request < 30) {
            System.out.println("handler request3");
        } else if (handler != null) {
            handler.handlerRequest(request);
        }
    }
}
