package com.f.bigtalk.chain_of_responsibility;

public class ConcreteHandler1 extends Handler {
    @Override
    public void handlerRequest(int request) {
        if (request > 0 && request < 10) {
            System.out.println("处理请求1");
        } else if (handler != null) {
            handler.handlerRequest(request);
        }


    }
}
