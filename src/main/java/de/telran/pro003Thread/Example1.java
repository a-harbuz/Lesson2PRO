package de.telran.pro003Thread;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int summ=0;
            for (int i = 0; i < 100_000; i++) {
                summ++;
            }
            System.out.println("End Thread1: ");
        });

        Thread t2 = new Thread(() -> {
            int summ=0;
            for (int i = 0; i < 100_000; i++) {
                summ--;
            }
            System.out.println("End Thread2: ");
        });

        Thread t3 = new Thread(() -> {
            double summ=1000000;
            for (int i = 0; i < 100_000; i++) {
                summ = summ * 0.9;
            }
            System.out.println("End Thread3: ");
        });

        Thread t4 = new Thread(() -> {
            double summ=10000;
            for (int i = 0; i < 100_000; i++) {
                summ = summ / 0.9;;
            }
            System.out.println("End Thread4: ");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        t1.join();
        t2.join();
        //t3.join();
        //t4.join();

        System.out.println("End Programm!!!");


    }
}
