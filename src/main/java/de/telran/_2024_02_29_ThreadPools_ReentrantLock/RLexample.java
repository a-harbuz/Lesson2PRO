package de.telran._2024_02_29_ThreadPools_ReentrantLock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class RLexample {
    private double balance;
    private Lock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        List lst = new ArrayList<>();
    }

}


class Th implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}