package de.telran.pro003Thread;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static long summ = 0;
    private static final List<Integer> list = new ArrayList<>(100_000);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        new Main2().counter();
    }

    public void counter() throws InterruptedException {
        double startTime = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < list.size() / 4; i++) {
                //synchronized(this) {
                    summ += list.get(i);
                //}
                //synchronizedMethod(i);
            }
            System.out.println("End Thread1: ");
        });

        Thread t2 = new Thread(() -> {
            for (int i = list.size() / 4; i < list.size() / 2; i++) {
                //synchronized(this) {
                    summ += list.get(i);
                //}
                //synchronizedMethod(i);
            }
            System.out.println("End Thread2: ");
        });

        Thread t3 = new Thread(() -> {
            for (int i = list.size() / 2; i < list.size() * 3 / 4; i++) {
                //synchronized(this) {
                    summ += list.get(i);
                //}
                //synchronizedMethod(i);
            }
            System.out.println("End Thread3: ");
        });

        Thread t4 = new Thread(() -> {
            for (int i = list.size() * 3 / 4; i < list.size(); i++) {
                //synchronized(this) {
                    summ += list.get(i);
                //}
                //synchronizedMethod(i);
            }
            System.out.println("End Thread4: ");
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();

//        t1.join();
//        t2.join();
//        t3.join();
//        t4.join();

        double endTime = System.currentTimeMillis();
        System.out.println("Time,ms: " + (endTime-startTime));  //16-20ms
        System.out.println("Summ: " + summ);

        //Этот способ - лажа = 32ms

        //10-15ms - потоки но без синхронизации
        //16-20ms - синхронизир
        //19-23ms - без потоков
    }
}
