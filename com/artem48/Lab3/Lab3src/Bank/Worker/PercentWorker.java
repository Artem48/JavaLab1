package Bank.Worker;

import Bank.Account.BaseAccount;
import Bank.BankRequest;

public class PercentWorker extends Worker {

    PercentWorker() {
        super(BankRequest.PERCENT);
    }


    @Override
    protected void concreteProcessRequest(BaseAccount account) {
        account.ApplyPercent();
    }
}
