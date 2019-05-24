package Bank.Account;

import Bank.Client.Client;
import Bank.WithdrawException;

public class Account extends BaseAccount {
    private double percent;

    public Account(Client client, double balance, double percent) {
        this.client = client;
        this.balance = balance;
        this.percent = percent;
    }

    @Override
    public void Withdraw(double value) {
        if(balance - value < 0)
            throw new WithdrawException("Not enough money");
        balance -= value;
    }

    @Override
    public void ApplyPercent() {
        balance += balance * percent;
    }

    @Override
    public void ApplyCommission() {
        return;
    }
}
