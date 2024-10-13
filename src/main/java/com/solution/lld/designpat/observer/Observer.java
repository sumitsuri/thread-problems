package com.solution.lld.designpat.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
