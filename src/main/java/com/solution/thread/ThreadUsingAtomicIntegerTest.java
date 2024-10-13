package com.solution.thread;

import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUsingAtomicIntegerTest {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static int get(){
        return counter.get();
    }

    public static int incrementCount(){
        return counter.incrementAndGet();
    }

    public static void increment() throws InterruptedException {
        System.out.println(String.format("Before: [%s] Thread: [%s] Time: [%s]", get(), Thread.currentThread().getId(), ZonedDateTime. now(). toInstant()));
//        Thread.sleep(100);
        System.out.println(String.format("After: [%s] Thread: [%s] Time: [%s]", incrementCount(), Thread.currentThread().getId(), ZonedDateTime. now(). toInstant()));
    }

    public static void main(String[] args) {
        System.out.println("Working thread");
        for(int i=0;i<50;i++){
            Thread t1 = new Thread(() -> {
                try {
                    increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
        }


    }
}
