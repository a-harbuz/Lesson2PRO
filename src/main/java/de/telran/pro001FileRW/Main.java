package de.telran.pro001FileRW;

import lombok.SneakyThrows;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //FileWriter
        ITExample thExampl = new ITExample();
        thExampl.start();
        System.out.println("Даю команду на завершение потока...");
        Thread.sleep(20);
        thExampl.interrupt();
        thExampl.join();
        System.out.println("Main End!");
    }
}




class ITExample extends Thread {
    double sqrt = 0;
    @SneakyThrows
    @Override
    public void run (){
        for (int i = 0; i < 1_000_000; i++) {
                System.out.println("Входим в спячку");
                Thread.sleep(10);
                System.out.println("Выходим из спячку");

            if (Thread.interrupted()){
                System.out.println("Прерываю поток.");
                //Закрыть корректно все рессурсы.
                return; //Корректное завершение потока
            }
            sqrt=Math.sqrt(i);
            try {
                Thread.sleep(22);
                //"Прервался во время сна"
            } catch (InterruptedException e) {
                System.out.println("Прервался во время сна");
                System.out.println(sqrt);
                return; //Корректное завершение потока

                //throw new RuntimeException("Прервался во время сна через throw");
            }
            return;

        }
    }
    //такое предположение, что при компиляции кода в байт код или машинный код,
    // у нас в конце всей программы (или метода) полюбому должен стоять return.
    // Иначе программа продолжиться выполняться дальше, и вообще непонятно какой код выполнит (не наш)


}