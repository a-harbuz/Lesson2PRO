package de.telran.pro004Thread2;

import java.util.concurrent.CountDownLatch;

public class CountDown {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
//            System.out.println("Countdown: " + countDownLatch.getCount());
//            System.out.println(Thread.currentThread().getName() + " Finished");
            try {
                countDownLatch.countDown();
                System.out.println("Countdown: " + countDownLatch.getCount());
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + " Finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task).start(); //start 3 threads
        }

    }
}
