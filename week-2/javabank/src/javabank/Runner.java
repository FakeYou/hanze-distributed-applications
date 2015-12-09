package javabank;
import javabank.DBHandlers.DBHandlerTransaction;
import javabank.Models.Transaction;

import javax.jws.WebService;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

public class Runner {

  public static void main(String[] argv) {
    // For Float comma to dot conversion
    Locale.setDefault(Locale.US);

    Transaction transaction = new Transaction();
    transaction.setDate(new Date(Calendar.getInstance().getTime().getTime()));
    transaction.setReceiverBic("IBAN005");
    transaction.setSenderBic("IBAN006");
    transaction.setAmount(50);

    DBHandlerTransaction dbHandlerTransaction = new DBHandlerTransaction();
    dbHandlerTransaction.addTransaction(transaction);

    int id = dbHandlerTransaction.addTransaction(new Transaction("IBAN005", "IBAN006", 50));

    System.out.println(id);
  }
}
