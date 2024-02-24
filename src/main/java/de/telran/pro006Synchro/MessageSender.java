package de.telran.pro006Synchro;

public class MessageSender {
    public static void main(String[] args) {
        Message msg = new Message("обработать"); //ПОЧТА-сообщение

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();
        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();
        Waiter waiter3 = new Waiter(msg);
        new Thread(waiter3, "waiter3").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start(); //Нотифаер будет все потоки Вайтер для обработки ПОЧТЫ

        System.out.println("Все потоки стартовали!");
    }
}

class Message {
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class Waiter implements Runnable {
    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " ждет сообщения (notify): "+System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " начинаем обрабатывать сообщение (notify): "+System.currentTimeMillis());
            // обрабатывам сообщение
            System.out.println(name+" обработал -> "+msg.getMsg());
            System.out.println(name + " закончил обрабатывать сообщение (notify): "+System.currentTimeMillis());
            //msg.notify();
        }
    }
}

class Notifier implements Runnable {
    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал.");
        try {
            Thread.sleep(2000);
            synchronized (msg) {
                System.out.println(name + " начал создавать сообщение.");
                msg.setMsg(name+" поток Notifier создал это сообщение!");
                //msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
