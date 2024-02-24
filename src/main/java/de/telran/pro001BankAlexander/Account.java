package de.telran.pro001BankAlexander;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Account implements Serializable {
    private long id;
    private String name;
    private String type;
    private StatusAccount status;
    private LocalDate createdAt;
    private LocalDate updateAt;
    private Double balance;
    private String currencyCode;
    private Client client;
}

