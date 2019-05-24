package Bank.Worker;

import Bank.Account.BaseAccount;
import Bank.BankRequest;

public class ComissionWorker extends Worker {

    ComissionWorker() {
        super(BankRequest.COMMISSION);
    }


    @Override
    protected void concreteProcessRequest(BaseAccount account) {
        account.ApplyCommission();
    }
}
