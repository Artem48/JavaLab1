import Bank.*;
import Bank.Account.*;
import Bank.Client.Client;
import Bank.Client.ClientBuilder;

public class Lab3 {
    public static void main(String[] args) {
        ClientBuilder builder=new ClientBuilder();
        Client client= builder.setName("Artem").setSurname("Popov").setAddress("Saint-Petersburg").setPassport("1234567890").Build();

        AccountFactory factory=new AccountFactory(5,10);
        BaseAccount defAcc= factory.createDefaultAccount(client,5000);

        BaseAccount creditAcc= factory.createCreditAccount(client,5000, 5000);

        System.out.printf("Before transfer balance1=%f balance2=%f\n",defAcc.getBalance(),creditAcc.getBalance());
        defAcc.TransferMoney(creditAcc,1000);
        System.out.printf("After transfer balance1=%f balance2=%f\n",defAcc.getBalance(),creditAcc.getBalance());

        defAcc.ApplyPercent();
        System.out.printf("After applying percent balance1=%f balance2=%f\n",defAcc.getBalance(),creditAcc.getBalance());


    }
}
