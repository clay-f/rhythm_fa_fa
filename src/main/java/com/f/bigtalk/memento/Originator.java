package com.f.bigtalk.memento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Originator {
    private String state;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    public void show() {
        logger.debug("state: {}", state);
    }

}
