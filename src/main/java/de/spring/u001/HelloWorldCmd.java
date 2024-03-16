package de.spring.u001;

public class HelloWorldCmd {
    public static void main(String[] args) {
        if (args.length>0) {
            System.out.println(args[0]);
            //жесткое связывание
        }
        else {
            System.out.println("Hello World");
        }
        //Нужно отвязать логику визуализации от
        //логики данных
    }
}
