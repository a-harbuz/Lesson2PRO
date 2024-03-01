package de.telran.pro007ThreadInterrupt;

import lombok.SneakyThrows;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //FileWriter
        ITExample1 thExampl = new ITExample1();
        thExampl.start();
        System.out.println("Даю команду на завершение потока...");
        Thread.sleep(20);
        thExampl.interrupt();
        thExampl.join();
        System.out.println("Main End!");
    }
}




class ITExample1 extends Thread {
    double sqrt = 0;
    //@SneakyThrows
    @Override
    public void run (){
        try {
            for (int i = 0; i < 1_000_000; i++) {
                //System.out.println("Входим в спячку");
                Thread.sleep(10);
                //System.out.println("Выходим из спячки");

//                if (isInterrupted()){
//
//                }
//                if (Thread.interrupted()) {
//                    System.out.println("Прерываю поток.");
//                    //Закрыть корректно все рессурсы.
//                    return; //Корректное завершение потока
//                }
                sqrt = Math.sqrt(i);
//                try {
//                    Thread.sleep(22);
//                    //"Прервался во время сна"
//                } catch (InterruptedException e) {
//                    System.out.println("Прервался во время сна");
//                    System.out.println(sqrt);
//                    return; //Корректное завершение потока
//                    //throw new RuntimeException("Прервался во время сна через throw");
//                }

            }

        } catch (InterruptedException e){
            System.out.println(sqrt);
            System.out.println("Корректное завершение потока!");
        }

    }
    //такое предположение, что при компиляции кода в байт код или машинный код,
    // у нас в конце всей программы (или метода) полюбому должен стоять return.
    // Иначе программа продолжиться выполняться дальше, и вообще непонятно какой код выполнит (не наш)


}