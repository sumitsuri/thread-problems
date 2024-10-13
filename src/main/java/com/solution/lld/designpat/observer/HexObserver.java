package com.solution.lld.designpat.observer;

public class HexObserver extends Observer{

    public HexObserver(Subject subject){
        this.subject = subject;
        subject.attachObserver(this);
    }

    @Override
    public void update() {
    System.out.println("Hex present" + Integer.toHexString(subject.getState()));
    }
}
