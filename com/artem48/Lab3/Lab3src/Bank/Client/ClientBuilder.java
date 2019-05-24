package Bank.Client;

import Bank.InsuffcicientDataException;

public class ClientBuilder {
    private String name;
    private String surname;
    private String address;
    private String passport;

    ClientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    ClientBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    ClientBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    ClientBuilder setPassport(String passport) {
        this.passport = passport;
        return this;
    }

    Client Build() {
        if (name == null || surname == null)
            throw new InsuffcicientDataException();
        return new Client(name, surname, address, passport);
    }
}
