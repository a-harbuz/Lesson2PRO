package de.telran.pro006Synchro;

public class SimpleDeadLock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread-1 получил lock1");
                try {
                    //lock1.выполнили какую то гадость над общим рессурсом
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-1 interrupted.");
                }
                System.out.println("Thread-1 ожидаем lock2");
                synchronized (lock2) {
                    System.out.println("Thread-1 получил lock2");
                    try {
                        //lock1.выполнили какую то гадость над общим рессурсом
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread-1 interrupted.");
                    }
                }
                System.out.println("Thread-1 освободил lock2");
            }
            System.out.println("Thread-1 освободил lock1");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) { // lock1 - будет решение проблемы deadlock
                System.out.println("Thread-2 получил lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-2 interrupted.");
                }
                System.out.println("Thread-2 ожидаем lock1");
                synchronized (lock1) {  // lock2 - будет решение проблемы deadlock
                    System.out.println("Thread-2 получил lock1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread-2 interrupted.");
                    }
                }
                System.out.println("Thread-2 освободил lock1");
            }
            System.out.println("Thread-2 освободил lock2");
        }
    }
}