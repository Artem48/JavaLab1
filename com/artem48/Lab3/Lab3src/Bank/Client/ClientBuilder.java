package Bank.Client;

import Bank.InsuffcicientDataException;

public class ClientBuilder {
    private String name;
    private String surname;
    private String address;
    private String passport;

    public ClientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ClientBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientBuilder setPassport(String passport) {
        this.passport = passport;
        return this;
    }

    public Client Build() {
        if (name == null || surname == null)
            throw new InsuffcicientDataException("Mandatory fields was not filled");
        return new Client(name, surname, address, passport);
    }
}
