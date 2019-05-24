package Bank.Worker;

import Bank.Account.BaseAccount;
import Bank.BankRequest;
import Bank.RequestProcessingException;

public abstract class Worker {
    protected Worker next;
    protected final BankRequest bankRequestType;

    Worker(BankRequest type) {
        bankRequestType = type;
    }

    public Worker setNext(Worker next) {
        this.next = next;
        return next;
    }

    public void processRequest(BankRequest request, BaseAccount account) {
        if (bankRequestType == request)
            concreteProcessRequest(account);
        else if (next != null)
            next.processRequest(request, account);
        else
            throw new RequestProcessingException("No worker can process request");

    }

    protected abstract void concreteProcessRequest(BaseAccount account);
}
