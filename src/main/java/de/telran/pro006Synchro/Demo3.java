package de.telran.pro006Synchro;

public class Demo3 {
    public static void main(String[] args) {

        //"Четырехугольник"
        //Легенда: 1) поставщик поставляет на главный склад в столице товар
        //2) товар перевозится из столицы на главный склад в городе
        //3) товар развозится на мелкие склады по районам
        //4) товар забирается покупателями

        Company company = new Company();
        Producer producer = new Producer(company);
        TransportToCity transportToCity = new TransportToCity(company);
        TransportToRegion transportToRegion = new TransportToRegion(company);
        Consumer consumer = new Consumer(company, "покупатель1");
        Consumer consumer2 = new Consumer(company, "покупатель2");

        Thread T1 = new Thread(producer);
        Thread T2 = new Thread(transportToCity);
        Thread T3 = new Thread(transportToRegion);
        Thread T4 = new Thread(consumer);
        Thread T5 = new Thread(consumer2);
        T1.start();
        T2.start();
        T3.start();
        T4.start();
        T5.start();
    }
}

class Company {
    private int itemCapital = 0;
    private int itemCity = 0;
    private int itemRegion = 0;
    public synchronized void putItem() {
        while (itemCapital >= 5) {
            try {
                wait(); //ждёт и освобождает монитор
                //System.out.println("Продолжаем.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        itemCapital++;
        System.out.println(">> a producer has put one item into the sklad in Capital" + " || " + "itemCapital count: " + itemCapital);
        //notify();
        notifyAll();
    }

    public synchronized void moveToCity() {
        while (itemCapital < 1 || itemCity >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        itemCapital--;
        itemCity++;
        System.out.println("<< TransportCompany moved one item to sklad to City" + " || " + "itemCity count: " + itemCity);
        //notify();
        notifyAll();
    }

    public synchronized void moveToRegion() {
        while (itemCity < 1 || itemRegion>=5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        itemCity--;
        itemRegion++;
        System.out.println("... TransportCompany moved one item to sklad of Region" + " || " + "itemRegion count: " + itemRegion);
        //notify();
        notifyAll();
    }

    public synchronized void getClient(String name) {
        while (itemRegion < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //itemCity--;
        itemRegion--;
        //System.out.println("(*) a person has bought one item" + " || " + "item's count: " + itemRegion);
        System.out.println(name + " has bought one item" + " || " + "item's count: " + itemRegion);
        //notify();
        notifyAll();
    }

}

//============================================================
class Producer implements Runnable {
    Company company;

    public Producer(Company company) {
        this.company =company;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10*2; i++) {
            company.putItem();
        }
    }
}

class TransportToCity implements Runnable {
    Company company;

    public TransportToCity(Company company) {
        this.company = company;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10*2; i++) {
            company.moveToCity();
        }
    }
}

class TransportToRegion implements Runnable {
    Company company;

    public TransportToRegion(Company company) {
        this.company = company;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10*2; i++) {
            company.moveToRegion();
        }
    }
}

class Consumer implements Runnable {
    Company company;
    String name;

    public Consumer(Company company, String name) {
        this.company = company;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            company.getClient(name);
        }
    }
}


