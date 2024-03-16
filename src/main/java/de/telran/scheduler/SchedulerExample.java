package de.telran.scheduler;

import net.bytebuddy.implementation.bytecode.Throw;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class SchedulerExample {
    public static int count=1;
    public static void main(String[] args) {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                System.out.println("Выполняем задачу в " + new Date());
                // Добавьте здесь код для выполнения задачи
                for (char i = 'a'; i < 'h'; i++) {
                    System.out.print(i);
                }
                System.out.println("");
                count++;
                if (count==4) throw new RuntimeException("End...");
            }
        };

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                SchedulerExample.sss();
            }
        };

        Thread th1 = new Thread(() -> {
            System.out.println(">>> Strat Thread1: ");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(">>> End Thread1: ");
        });

        // Запустить задачу через 5 секунд, повторять каждые 10 секунд
        timer.schedule(task, 4000, 6000);
        timer.schedule(task1, 3000, 3000);
        th1.start();
        // ждет пока поток не закончится, несмотря на исключение
    }

    public static void sss (){
        System.out.println("sss");
    }

}
