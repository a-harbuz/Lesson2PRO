package de.telran.pro002ThreadBegin;

public class W1 {
//    public static void main(String[] args) {
//        Market market = new Market();
//
//        Producer producer = new Producer(market);
//        Consumer consumer = new Consumer(market);
//
//        Thread T1 = new Thread(producer);
//        Thread T2 = new Thread(consumer);
//
//        T1.start();
//        T2.start();
//    }
}

//class Market {
//    private int item = 0; //общий рессурс
//
//    public synchronized void getItem() { //synchronized
//        while (item < 1) {
//            try {
//                wait(); //если = 0, склад пуст, останавливаем поток
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        item--;
//        System.out.print("Забрали один, ");
//        System.out.println("count: " + item);
//        //notify();
//    }
//
//    public synchronized void putItem() { //synchronized
//        while (item >= 5) {
//            try {
//                wait(); //если = 5, склад забит, останавливаем поток
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        item++;
//        System.out.print("Положили один, ");
//        System.out.println("count: " + item);
//        //notify();
//    }
//
//
//}
//
//class Producer implements Runnable {
//    Market market;
//
//    public Producer(Market market) {
//        this.market =market;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            market.putItem();
//        }
//    }
//}
//
//class Consumer implements Runnable {
//    Market market;
//
//    public Consumer(Market market) {
//        this.market = market;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            market.getItem();
//        }
//    }
//}
//
