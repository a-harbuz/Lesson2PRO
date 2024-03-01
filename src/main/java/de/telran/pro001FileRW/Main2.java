package de.telran.pro001FileRW;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {
    //@SneakyThrows
    public static void main(String[] args) {
        //String path =
        try (FileWriter fileWriter = new FileWriter("test1.txt")) {
            for (char i = 'a'; i < 'z'; i++) {
                fileWriter.write(i+"\n");
                //fileWriter.append(i);
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }

        try (FileReader fileReader = new FileReader("test1.txt")) {
            //пока есть непрочитанные байты в потоке ввода
            while (fileReader.ready()){
                //читаем один символ (char будет расширен до int)
                int data = fileReader.read();
                System.out.println((char) data);
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test1.txt"))) {
            //пока есть непрочитанные байты в потоке ввода
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Выводим прочитанную строку
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
