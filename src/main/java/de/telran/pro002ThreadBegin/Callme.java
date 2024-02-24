package de.telran.pro002ThreadBegin;

public class Callme {
    void call(String  msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException е) {
            System.out.println("Пpepвaнo ");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    final Callme target;
    Thread t;
    public Caller (Callme targ, String s)   {
        target = targ;
        msg = s ;
        t = new Thread (this);
        t.start();
    }

    @Override
    public void  run ( ) {
        synchronized (target) { //обьект
           target.call (msg) ;  //его метод
        }
    }

}

class Synch {
    public static void main(String args[]) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать ");
        Caller ob2 = new Caller(target, "в синхронизированный ");
        Caller ob3 = new Caller(target, "мир ! ");
        //   ожидать завершения потока исполнения
//        try {
//            ob1.t.join();
//            ob2.t.join();
//            ob3.t.join();
//        } catch (InterruptedException e) {
//            System.out.println("Пpepвaнo");
//        }

    }
}

//synchronized (ссылка_на_объект)  {        //обьект
        //   синхронизиру ёМые  операторы   //его метод
//}
