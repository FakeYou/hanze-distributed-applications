package example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.HashMap;

@WebService
public class Bank {

    private HashMap<String, Account> accounts = new HashMap<>();

    @WebMethod
    public void openAccount(Account account) {
        if(!accounts.containsKey(account.getBic())) {
            accounts.put(account.getBic(), account);
        }
    }

    @WebMethod
    public boolean transfer(float amount, String fromBic, String toBic) {

    }

    @WebMethod
    public Account getAccount(String bic) {
        return accounts.get(bic);
    }

    @WebMethod
    public void alterAccount(Account account) {
        if(accounts.containsKey(account.getBic())) {
            accounts.put(account.getBic(), account);
        }
    }

    @WebMethod
    public Transation[] getTransactions(String bic, String date) {
        return null;
    }

}
