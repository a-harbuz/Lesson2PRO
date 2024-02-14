package de.telran.pro001BankMain;

import java.io.Serializable;
import java.time.LocalDate;

public class Manager implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private StatusManager status;
    private LocalDate createAt;
    private LocalDate update;
    //simple POJO object;

    public Manager(long id, String firstName, String lastName, StatusManager status, LocalDate createAt, LocalDate update) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.createAt = createAt;
        this.update = update;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //Objects.hashCode(id) - можем сократить до этого

        Manager manager = (Manager) o;

        if (id != manager.id) return false;
        if (!firstName.equals(manager.firstName)) return false;
        if (!lastName.equals(manager.lastName)) return false;
        if (status != manager.status) return false;
        if (!createAt.equals(manager.createAt)) return false;
        return update.equals(manager.update);
    }

    @Override
    public int hashCode() {
        //Objects.hashCode(id) - можем сократить до этого
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createAt.hashCode();
        result = 31 * result + update.hashCode();
        return result;
    }
}

