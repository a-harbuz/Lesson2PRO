package de.telran.pro005CyclingBarier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class Main3 {
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

        //===========================================================================
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
