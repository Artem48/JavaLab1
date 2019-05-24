package Bank.Account;

import Bank.Client.Client;
import Bank.WithdrawException;

import java.util.Date;

public class DepositAccount extends BaseAccount {
    private  double percent;
    private Date until;

    public DepositAccount(Client client, double balance, double percent, Date until) {
        this.client = client;
        this.balance = balance;
        this.percent = percent;
        this.until = until;
    }

    @Override
    public void Withdraw(double value) {
        if(until.before(new Date()))
            throw new WithdrawException("Can't withdraw from deposit account before it expires");
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
