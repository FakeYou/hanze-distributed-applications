package javabank.WebServices;

import javabank.DBHandlers.DBHandler;
import javabank.DBHandlers.DBHandlerAccount;
import javabank.DBHandlers.DBHandlerTransaction;
import javabank.Models.Account;
import javabank.Models.Transaction;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.sql.Connection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

@WebService()
public class JavaBank {
    DBHandlerAccount dbHandlerAccount;
    DBHandlerTransaction dbHandlerTransaction;

    public JavaBank() {
        Locale.setDefault(Locale.US);

        dbHandlerAccount = new DBHandlerAccount();
        dbHandlerTransaction = new DBHandlerTransaction();
    }

    @WebMethod
    @WebResult(name="Account")
    public Account getAccount(@WebParam(name="bic") String bic) {
        return dbHandlerAccount.getAccount(bic);
    }

    @WebMethod
    public void openAccount(@WebParam(name="Account") Account account) {
        dbHandlerAccount.addAccount(account);
    }

    @WebMethod
    public void alterAccount(@WebParam(name="Account") Account account) {
        dbHandlerAccount.updateAccount(account);
    }

    @WebMethod
    @WebResult(name="success")
    public boolean transfer(@WebParam(name="amount") float amount, @WebParam(name="senderBic") String senderBic,
                            @WebParam(name="receiverBic") String receiverBic) {

        Account senderAccount = dbHandlerAccount.getAccount(senderBic);
        Account receiverAccount = dbHandlerAccount.getAccount(receiverBic);

        if (senderAccount == null || receiverAccount == null || amount > senderAccount.getCredit()) {
            return false;
        }
        else {
            senderAccount.setBalance(senderAccount.getBalance() - amount);
            receiverAccount.setBalance(receiverAccount.getBalance() + amount);

            dbHandlerAccount.updateAccount(senderAccount);
            dbHandlerAccount.updateAccount(receiverAccount);

            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setSenderBic(senderBic);
            transaction.setReceiverBic(receiverBic);
            transaction.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));

            dbHandlerTransaction.addTransaction(transaction);

            return true;
        }
    }

    @WebMethod
    @WebResult(name="Transaction")
    @XmlElementWrapper(name="Transactions")
    public Transaction[] getTransactions(String bic, String date) {
        ArrayList<Transaction> transactions = dbHandlerTransaction.getTransactions(bic, date);

        return transactions.toArray(new Transaction[transactions.size()]);
    }
}
