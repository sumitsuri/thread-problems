package com.test.thread;

import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadReentrantLockTest {

    //sout
    private static Integer counter = 0;
    private static Lock lock = new ReentrantLock();

    public static void increment(){
        try{
            System.out.println();
            lock.lock();
            System.out.println(String.format("Before: [%s] Thread: [%s]", counter, Thread.currentThread().getId()));
            counter = counter + 1;
            System.out.println(String.format("After: [%s] Thread: [%s]", counter, Thread.currentThread().getId()));
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        System.out.println("Working thread");
        for(int i=0;i<10;i++){
            Thread t1 = new Thread(() -> increment());
            t1.start();
        }


    }
}
