package Bank.Account;

import Bank.TransferException;
import Bank.WithdrawException;

public class UnverifiedAccount extends BaseAccount {
    private BaseAccount baseAccount;
    private static final double unverifiedLimit = 500;

    UnverifiedAccount(BaseAccount baseAccount) {
        this.baseAccount = baseAccount;
    }

    @Override
    public void Withdraw(double value) {
        if (value < unverifiedLimit)
            baseAccount.Withdraw(value);
        else
            throw new WithdrawException("Can't withdraw that much with unverified account");
    }

    @Override
    void TransferMoney(BaseAccount other, double value) {
        if (value < unverifiedLimit)
            baseAccount.TransferMoney(other, value);
        else
            throw new TransferException("Can't withdraw that much with unverified account");
    }

    @Override
    public void Deposit(double value) {
        baseAccount.Deposit(value);
    }

    @Override
    public void ApplyPercent() {
        baseAccount.ApplyPercent();
    }

    @Override
    public void ApplyCommission() {
        baseAccount.ApplyCommission();
    }
}
