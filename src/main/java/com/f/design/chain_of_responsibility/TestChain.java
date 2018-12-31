package com.f.design.chain_of_responsibility;

public class TestChain {
    public static void main(String[] args) {
        Handler handler = new ConcreteHandler1();
        Handler handler1 = new ConcreteHandler2();
        Handler handler2 = new ConcreteHandler3();
        handler.setHandler(handler1);
        handler1.setHandler(handler2);

        int[] requests = {1, 2, 10, 11, 25, 26, 27, 28};
        for (int i = 0; i < requests.length - 1; i++) {
            handler.handlerRequest(requests[i]);
        }
    }
}
