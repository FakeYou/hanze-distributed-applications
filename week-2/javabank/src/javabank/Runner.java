package javabank;
import javabank.DBHandlers.DBHandlerTransaction;
import javabank.Models.Transaction;

import javax.jws.WebService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Runner {

  public static void main(String[] argv) {
    // For Float comma to dot conversion
    Locale.setDefault(Locale.US);


    BankOperations bankOperations = new BankOperations();
          System.out.printf("" + bankOperations.transfer(5000000, "IBAN500", "IBAN501"));
  }
}
