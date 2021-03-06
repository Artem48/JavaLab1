package Bank.Account;

import Bank.Client.Client;
import Bank.WithdrawException;

public class DefaultAccount extends BaseAccount {
    private double percent;

    public DefaultAccount(Client client, double balance, double percent) {
        this.client = client;
        this.balance = balance;
        this.percent = percent;
    }

    @Override
    public void Withdraw(double value) {
        if (balance - value < 0)
            throw new WithdrawException("Not enough money");
        balance -= value;
    }

    @Override
    public void ApplyPercent() {
        balance += balance * (100+percent)/100.0;
    }

    @Override
    public void ApplyCommission() {
        return;
    }
}
