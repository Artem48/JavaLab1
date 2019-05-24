package Bank.Client;

public class Client {
    private String name;
    private String surname;
    private String address;
    private String passport;

    public String getAddress() {
        return address;
    }

    public String getPassport() {
        return passport;
    }



    public Client(String name, String surname, String address, String passport) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.passport = passport;
    }
}
