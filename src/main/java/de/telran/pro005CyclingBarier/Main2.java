package de.telran.pro005CyclingBarier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main2 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        MainClass mainObj = new MainClass();
        Thread t1 = new Thread(mainObj);
        t1.start();
    }
}

class Task extends Thread {
    String name;
    Random random = new Random();
    public Task(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println(name + " start.");
            Thread.sleep(1000 * random.nextInt(5));
            System.out.println(name + " finish.");
            System.out.println(name + " ждет остальных потоков");
            MainClass.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}

class MainClass implements Runnable {
    public static CyclicBarrier barrier = new CyclicBarrier(3);

//    public static CyclicBarrier barrier = new CyclicBarrier(3, () -> {
//        System.out.println("All threads reached the barrier, let's continue...");
//    });

    @Override
    public void run() {
        System.out.println("Task-1 start.");
        System.out.println("Количество частей, ожидающих Барьера = " + barrier.getParties());

        Task task2 = new Task("Task-2");
        Task task3 = new Task("Task-3");

        // Запускаем 2 других потока
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t2.start();
        t3.start();

        try {
            Thread.sleep(5999);
            System.out.println("Task-1 ждет остальных потоков");
            MainClass.barrier.await();
            //MainClass.barrier.await(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        MainClass.barrier.reset();

        System.out.println("Дождались завершения всех потоков");
        System.out.println("Идём дальше...");

    }
}