package de.telran.pro002ThreadBegin;

class KakoytoFuckingClass {
    void fuck() {
        System.out.print("fuck!");

    }
}

class My2 implements Runnable {
    //KakoytoFuckingClass kakoytoFuckingClass;

    @Override
    public void run() {
        //synchronized (kakoytoFuckingClass) { //обьект
            //kakoytoFuckingClass.fuck(); ;  //его метод
        System.out.print("fuck!");
        //}
    }
}

class Main {
    public static void main(String[] args) {
        Thread th1 = new Thread(new My2());
        Thread th2 = new Thread(new My2());
        Thread th3 = new Thread(new My2());
        Thread th4 = new Thread(new My2());

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}