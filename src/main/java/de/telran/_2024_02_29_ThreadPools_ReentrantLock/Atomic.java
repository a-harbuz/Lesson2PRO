package de.telran._2024_02_29_ThreadPools_ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    public static int countInt = 0;
    public static int tmp = 0;

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();

        count.set(0);
        //count.set(16);
        Object obj1 = new Object();

        //System.out.println(count.incrementAndGet()); //17
        //System.out.println(count.addAndGet(10)); //27

        new Thread(()->{
            for (int i = 0; i < 1200; i++) {
                synchronized (obj1) {
                    try {
                        count.incrementAndGet();
                        countInt++;
                        //System.out.println("TH1 " + count + "  " + countInt);
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("TH1 " + count + "  " + countInt);
            //cумма от Атомика и Интеджера Отличаются
        }).start();


        new Thread(()->{
            tmp = count.get();
            for (int i = 0; i < 1200; i++) {
                synchronized (obj1) {
                    try {
                        //if (!count.compareAndSet(tmp,count.get()))count.incrementAndGet();
                        //count.incrementAndGet();
                        //countInt++;
                        //count.get();
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("TH2 " + count + "  " + countInt);
        }).start();



    }
}
