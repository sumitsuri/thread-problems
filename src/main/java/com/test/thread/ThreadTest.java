package com.test.thread;

public class ThreadTest {

    private static Integer counter = 0;

    public synchronized static void increment(){
        System.out.println(String.format("Before: [%s] Thread: [%s]", counter, Thread.currentThread().getId()));
        counter = counter + 1;
        System.out.println(String.format("After: [%s] Thread: [%s]", counter, Thread.currentThread().getId()));
    }

    public static void main(String[] args) {
        System.out.println("Working thread");
        for(int i=0;i<10;i++){
            Thread t1 = new Thread(() -> increment());
            t1.start();
        }


    }
}
