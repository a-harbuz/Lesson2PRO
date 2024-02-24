package de.telran.pro001BankAlexander;

import java.io.Serializable;
import java.time.LocalDate;

public class Client implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private StatusManager status;
    private LocalDate createAt;
    private LocalDate update;
    private String eMail;
    private String adress;
    private String phone;
    private Manager manager;
    //simple POJO object;

    public Client(long id, String firstName, String lastName, StatusManager status, LocalDate createAt, LocalDate update, String eMail, String adress, String phone, Manager manager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.createAt = createAt;
        this.update = update;
        this.eMail = eMail;
        this.adress = adress;
        this.phone = phone;
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (!firstName.equals(client.firstName)) return false;
        if (!lastName.equals(client.lastName)) return false;
        if (status != client.status) return false;
        if (!createAt.equals(client.createAt)) return false;
        if (!update.equals(client.update)) return false;
        if (!eMail.equals(client.eMail)) return false;
        if (!adress.equals(client.adress)) return false;
        if (!phone.equals(client.phone)) return false;
        return manager.equals(client.manager);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createAt.hashCode();
        result = 31 * result + update.hashCode();
        result = 31 * result + eMail.hashCode();
        result = 31 * result + adress.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + manager.hashCode();
        return result;
    }
}
