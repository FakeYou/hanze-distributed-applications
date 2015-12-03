package example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@WebService
public class Bank {

    private HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();

        accounts.put("1234", new Account("Test1", "1234"));
    }

    @WebMethod
    public void openAccount(@WebParam(name="Account") Account account) {
        if(!accounts.containsKey(account.getBic())) {
            accounts.put(account.getBic(), account);
        }
    }

    @WebMethod
    @WebResult(name="Account")
    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    @WebMethod
    public boolean transfer(@WebParam(name="amount") float amount, @WebParam(name="from") String fromBic, @WebParam(name="to") String toBic) {
        Account fromAccount = accounts.get(fromBic);
        Account toAccount = accounts.get(toBic);

        if(fromAccount != null && toAccount != null && fromAccount.getCredit() >= amount) {
            fromAccount.setCredit(fromAccount.getCredit() - amount);
            toAccount.setCredit(toAccount.getCredit() + amount);
            return true;
        }

        return false;
    }

    @WebMethod
    @WebResult(name="Account")
    public Account getAccount(String bic) {
        return accounts.get(bic);
    }

    @WebMethod
    public void alterAccount(@WebParam(name="Account") Account account) {
        if(accounts.containsKey(account.getBic())) {
            accounts.put(account.getBic(), account);
        }
    }

//    @WebMethod
//    public Transation[] getTransactions(String bic, String date) {
//        return null;
//    }

}
