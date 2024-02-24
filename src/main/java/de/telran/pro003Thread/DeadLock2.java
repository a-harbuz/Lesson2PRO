package de.telran.pro003Thread;

public class DeadLock2 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    public static void main(String[] args) {
//        Th11 th1 = new Th11();
//        Th22 th2 = new Th22();
//
//        Thread t1 = new Thread(th1);
//        Thread t2 = new Thread(th2);
//        t1.start();
//        t2.start();
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Удержание блокировки 1...");
                try {
                    Thread.sleep(100);
                    //ждем окончания потока
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Удержание блокировки 1 and lock 2...");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Удержание блокировки 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Удержание блокировки 2 and lock 1...");
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}



class Th11 implements Runnable {
    //Th22 th2 = new Th22();
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("TH1 I: " + i);
            }
        }
    }
}

class Th22 implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("TH2 I: " + i);
            }
        }
    }
}