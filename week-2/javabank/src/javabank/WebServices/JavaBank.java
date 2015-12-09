package javabank.WebServices;

import javabank.DBHandlers.DBHandlerAccount;
import javabank.DBHandlers.DBHandlerTransaction;
import javabank.Models.Account;
import javabank.Models.Transaction;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
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
    @WebResult(name="success")
    public boolean transfer(@WebParam(name="amount") float amount, @WebParam(name="senderBic") String senderBic,
                            @WebParam(name="receiverBic") String receiverBic) { boolean transferSuccessful = false;

        DBHandlerAccount dbHandlerAccount = new DBHandlerAccount();

        Account senderAccount = dbHandlerAccount.getAccount(senderBic);
        Account receiverAccount = dbHandlerAccount.getAccount(receiverBic);

        if (senderAccount == null || receiverAccount == null || amount > senderAccount.getCredit()) {
            return transferSuccessful;
        } else {

            senderAccount.setBalance(senderAccount.getBalance() - amount);
            receiverAccount.setBalance(receiverAccount.getBalance() + amount);

            dbHandlerAccount.updateAccount(senderAccount);
            dbHandlerAccount.updateAccount(receiverAccount);

            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setSenderBic(senderBic);
            transaction.setReceiverBic(receiverBic);
            transaction.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));

            DBHandlerTransaction dbHandlerTransaction = new DBHandlerTransaction();
            dbHandlerTransaction.addTransaction(transaction);

            transferSuccessful = true;
        }

        return transferSuccessful;
    }
//
//    @WebMethod
//    @WebResult(name="Transaction")
//    public Transaction[] getTransactions(String bic, String date) {
//        return null;
//    }
}
