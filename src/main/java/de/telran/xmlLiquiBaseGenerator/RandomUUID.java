package de.telran.xmlLiquiBaseGenerator;

import java.util.UUID;

public class RandomUUID {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString().replace("-",""));
        }

    }
}

//Актуальный вопрос: «Как выполнить функцию MySQL UNHEX() в Java»
//1.1 Что на самом деле делает функция UNHEX() в MySQL
//Ответ на этот вопрос довольно прост. Он принимает строку шестнадцатеричных символов и преобразует ее в двоичный объект.
//
//Имейте в виду: шестнадцатеричная строка — это просто один из многих способов представления байтов в виде текста. И насколько бы простым ни было это предложение, ответ на этот вопрос — нам просто нужно преобразовать эту строку в файл byte[].
//
//И благодаря этим знаниям у нас есть ответ, который уже был здесь, на SO много лет назад:
//https://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java
//Обновление (2021 г.) — Java 17 теперь включает java.util.HexFormat(прошло всего 25 лет):
//HexFormat.of().parseHex(s)

//Для более старых версий Java:
//        Вот решение, которое, на мой взгляд, лучше, чем любое опубликованное до сих пор:
//
///* s must be an even-length string. */
//public static byte[] hexStringToByteArray(String s) {
//    int len = s.length();
//    byte[] data = new byte[len / 2];
//    for (int i = 0; i < len; i += 2) {
//        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
//                + Character.digit(s.charAt(i+1), 16));
//    }
//    return data;
//}

