package javabank;

import javabank.DBHandlers.DBHandlerAccount;
import javabank.Models.Account;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.HashMap;

@WebService
public class BankOperations {

    private HashMap<String, Account> accounts;

    public BankOperations() {
        accounts = new HashMap<>();

        accounts.put("1234", new Account("Test1", "1234"));
    }

    @WebMethod
    public void openAccount(@WebParam(name="Account") Account account) {
        if(!accounts.containsKey(account.getBic())) {
            accounts.put(account.getBic(), account);
        }
        DBHandlerAccount dbHandlerAccount = new DBHandlerAccount();
        dbHandlerAccount.addAccount(account);
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
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
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
