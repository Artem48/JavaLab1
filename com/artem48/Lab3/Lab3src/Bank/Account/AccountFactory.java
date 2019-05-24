package Bank.Account;

import Bank.Client.Client;

import java.util.Date;

public class AccountFactory {
    private double percent;
    private double commission;

    public AccountFactory(double percent, double commission) {
        this.percent = percent;
        this.commission = commission;
    }

    public BaseAccount createAccount(Client client, double balance) {
        if (client.getAddress() == null || client.getPassport() == null)
            return new UnverifiedAccount(new Account(client, balance, percent));
        else
            return new Account(client, balance, percent);
    }

    public BaseAccount createAccount(Client client, double balance, Date until) {
        if (client.getAddress() == null || client.getPassport() == null)
            return new UnverifiedAccount(new DepositAccount(client, balance, percent, until));
        else
            return new DepositAccount(client, balance, percent, until);
    }

    public BaseAccount createAccount(Client client, double balance, double limit) {
        if (client.getAddress() == null || client.getPassport() == null)
            return new UnverifiedAccount(new CreditAccount(client, balance, limit, commission));
        else
            return new CreditAccount(client, balance, limit, commission);
    }
}
