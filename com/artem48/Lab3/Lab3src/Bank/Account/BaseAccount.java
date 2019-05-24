package Bank.Account;

import Bank.Client.Client;
import Bank.TransferException;

public abstract class BaseAccount {
    protected Client client;
    protected double balance;

    void TransferMoney(BaseAccount other, double value) {
        if (!other.client.equals(client))
            throw new TransferException("Transferring is permitted only between same client's accounts");

    }

    public void Deposit(double value) {
        balance += value;
    }

    public abstract void Withdraw(double value);

    public abstract void ApplyPercent();

    public abstract void ApplyCommission();
}
