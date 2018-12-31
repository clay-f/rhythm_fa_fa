package com.f.design.chain_of_responsibility;

public abstract class Handler {
    protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handlerRequest(int request);
}
