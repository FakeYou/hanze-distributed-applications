package javabank;
import javabank.DBHandlers.DBHandler;
import javabank.DBHandlers.DBHandlerAccount;
import javabank.Models.Account;

import javax.jws.WebService;
import java.util.Locale;

@WebService()
public class Runner {

  public static void main(String[] argv) {
    // For Float comma to dot conversion
    Locale.setDefault(Locale.US);

    DBHandlerAccount dbHandlerAccount = new DBHandlerAccount();

    Account lasse = new Account();
    lasse.setBalance(50);
    lasse.setBic("IBAN500");
    lasse.setName("Lasse");
    lasse.setAddress("Nee");
    lasse.setCity("Nooit");
    lasse.setLimit(5000);

//    dbHandlerAccount.addAccount(lasse);
    Account lol = dbHandlerAccount.getAccount(lasse.getBic());
    lol.getName();
  }
}
