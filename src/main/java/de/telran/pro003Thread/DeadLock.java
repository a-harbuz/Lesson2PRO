package de.telran.pro003Thread;

public class DeadLock {
    public static int count = 0;
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread th1 = new Thread(()->{
            synchronized (obj1) {
                for (int i = 0; i < 5; i++) {
                    count++;
                    System.out.println("th1: " + count);
                }
            }

            synchronized (obj2) {

            }
        });

        Thread th2 = new Thread(()->{
            synchronized (obj2) {
                for (int i = 0; i < 5; i++) {
                    count++;
                    System.out.println("th2: " + count);
                }
            }

            synchronized (obj1) {

            }

        });

        th1.start();
        th2.start();

    }
}

//===============================
class summ {
    public void mt () {
        synchronized (this) {


        }
    }


}


