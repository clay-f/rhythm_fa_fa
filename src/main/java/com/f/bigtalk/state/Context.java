package com.f.bigtalk.state;

public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public Context() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.Handle(this);
    }
}
