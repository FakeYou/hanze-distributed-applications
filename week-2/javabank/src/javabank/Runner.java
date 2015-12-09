package javabank;
import javabank.DBHandlers.DBHandler;
import javabank.DBHandlers.DBHandlerAccount;
import javabank.DBHandlers.DBHandlerTransaction;
import javabank.Models.Account;
import javabank.Models.Transaction;

import javax.jws.WebService;
import java.sql.Date;
import java.sql.SQLData;
import java.util.Calendar;
import java.util.Locale;

@WebService()
public class Runner {

  public static void main(String[] argv) {
    // For Float comma to dot conversion
    Locale.setDefault(Locale.US);

    Transaction transaction = new Transaction();
    transaction.setDate(new Date(Calendar.getInstance().getTime().getTime()));
    transaction.setReceiver_bic("IBAN005");
    transaction.setSender_bic("IBAN006");
    transaction.setAmount(50);

    DBHandlerTransaction dbHandlerTransaction = new DBHandlerTransaction();
    dbHandlerTransaction.addTransaction(transaction);

  }
}
