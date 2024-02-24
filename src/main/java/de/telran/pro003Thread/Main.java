package de.telran.pro003Thread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static long summ = 0;

    private static final List<Integer> list = new ArrayList<>(100_000);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        new Main().counter();
    }

    public synchronized void synchronizedMethod(int i) {
        // Код, который требуется синхронизировать
        summ += list.get(i);
    }
    public void counter() throws InterruptedException {
            double startTime = System.currentTimeMillis();

            Thread t1 = new Thread(() -> {
                for (int i = 0; i < list.size() / 4; i++) {
                    //summ += list.get(i);
                    synchronizedMethod(i);
                }
                System.out.println("End Thread1: ");
            });

            Thread t2 = new Thread(() -> {
                for (int i = list.size() / 4; i < list.size() / 2; i++) {
                    //summ += list.get(i);
                    synchronizedMethod(i);
                }
                System.out.println("End Thread2: ");
            });

            Thread t3 = new Thread(() -> {
                for (int i = list.size() / 2; i < list.size() * 3 / 4; i++) {
                    //summ += list.get(i);
                    synchronizedMethod(i);
                }
                System.out.println("End Thread3: ");
            });

            Thread t4 = new Thread(() -> {
                for (int i = list.size() * 3 / 4; i < list.size(); i++) {
                    //summ += list.get(i);
                    synchronizedMethod(i);
                }
                System.out.println("End Thread4: ");
            });

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();

            double endTime = System.currentTimeMillis();
            System.out.println("Time,ms: " + (endTime-startTime));  //16-20ms
            System.out.println("Summ: " + summ);

            //10-15ms - 4 потока, но без синхронизации
            //16-20ms - синхронизир
            //19-23ms - без потоков
    }

}
