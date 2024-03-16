package de.telran.xmlLiquiBaseGenerator;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RandomTimestamp {
    public static void main(String[] args) {
//        Timestamp ts = new Timestamp();
//        ts.getTime();
//        System.out.println(ts);
        LocalDateTime time = LocalDateTime.now();
        System.out.println("Сейчас = " + time);

        LocalDate date = LocalDate.now();
        System.out.println("Сейчас = " + date);

        Instant timestamp = Instant.now();
        System.out.println(timestamp);
    }
}
