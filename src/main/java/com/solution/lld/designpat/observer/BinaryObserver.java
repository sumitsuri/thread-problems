package com.solution.lld.designpat.observer;

public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        subject.attachObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Hex present" + Integer.toBinaryString(subject.getState()));
    }
}
