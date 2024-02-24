package de.telran.pro005CyclingBarier;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args)
    {
        // parent thread
        Tester test = new Tester();

        Thread t1 = new Thread(test);
        t1.start();
    }
}


class Computation1 implements Runnable
{
    public static int product = 0;
    @Override
    public void run()
    {
        System.out.println("Запустили поток Computation1");
        product = 2 * 3;
        try
        {
            Thread.sleep(2500);
            System.out.println("Computation1 ждет остальных потоков");
            Tester.newBarrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }
}

class Computation2 implements Runnable
{
    public static int sum = 0;
    @Override
    public void run()
    {
        System.out.println("Запустили поток Computation2");
        // check if newBarrier is broken or not
        System.out.println("Is the barrier broken? - " + Tester.newBarrier.isBroken());
        sum = 10 + 20;
        System.out.println("Computation2 ждет остальных потоков");
        try
        {
            Tester.newBarrier.await(7000, TimeUnit.MILLISECONDS);

            // number of parties waiting at the barrier
            System.out.println("Количество частей, ожидающих Барьера "+
                    "at this point = " + Tester.newBarrier.getNumberWaiting());
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }
        catch (TimeoutException e)
        {
            e.printStackTrace();
        }
    }
}


class Tester implements Runnable
{
    public static CyclicBarrier newBarrier = new CyclicBarrier(3);

    @Override
    public void run()
    {
        System.out.println("Количество частей, ожидающих Барьера = "+
                newBarrier.getParties());
        System.out.println("Sum of product and sum = " + (Computation1.product +
                Computation2.sum));

        // objects on which the child thread has to run
        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();

        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);

        // moving child thread to runnable state
        t1.start();
        t2.start();

        try
        {
            Thread.sleep(6999);
            System.out.println("Tester ждет остальных потоков");
            Tester.newBarrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }

        // barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (Computation1.product +
                Computation2.sum));

        // Resetting the newBarrier
        newBarrier.reset();
        System.out.println("Barrier reset successful");
    }
}
