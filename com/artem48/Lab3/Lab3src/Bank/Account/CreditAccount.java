package Bank.Account;

import Bank.Client.Client;
import Bank.WithdrawException;

public class CreditAccount extends BaseAccount {
    private double limit;
    private double commission;

    public CreditAccount(Client client, double balance, double limit, double comission) {
        this.client = client;
        this.balance = balance;
        this.limit = limit;
        this.commission = comission;
    }

    @Override
    public void Withdraw(double value) {
        if(balance - value < limit)
            throw new WithdrawException("Not enough money");
        balance -= value;
    }

    @Override
    public void ApplyPercent() {
        return;
    }

    @Override
    public void ApplyCommission() {
        if(balance < 0)
            balance -= commission;
    }
}
