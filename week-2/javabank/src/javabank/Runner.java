package javabank;
import javabank.DBHandlers.DBHandlerTransaction;
import javabank.Models.Transaction;
import javabank.WebServices.JavaBank;

import javax.jws.WebService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

public class Runner {

  public static void main(String[] argv) {
        // For Float comma to dot conversion
        Locale.setDefault(Locale.US);


        JavaBank javaBank = new JavaBank();
        System.out.printf("" + javaBank.transfer(5, "CY60979006261151065725792620", "IS441552425328519418046062"));
    }
}
