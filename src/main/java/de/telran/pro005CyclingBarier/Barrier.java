package de.telran.pro005CyclingBarier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class Barrier {
    private static final int NUM_THREADS = 3;
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                // Симуляция выполнения некоторой работы
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Создание барьера, ожидающего NUM_THREADS потоков
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("All threads reached the barrier, let's continue...");
        });

        thRun(task,barrier);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thRun(task,barrier);
        //Thread.interrupt(); //прерывание потока
        //while (!Thread.currentThread().isInterrupted()) {
            // Выполнение какой-то работы
        //}
        //===========================================================================
    }

    public static void thRun(Runnable task, CyclicBarrier barrier) {
        // ИСКУССОНОЕ Создание и запуск потоков !!
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // Добавляем задачу
                    task.run();
                    // Дожидаемся остальных потоков у барьера
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

}
