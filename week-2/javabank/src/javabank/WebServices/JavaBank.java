package javabank.WebServices;

import javabank.DBHandlers.DBHandlerAccount;
import javabank.Models.Account;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Locale;

@WebService()
public class JavaBank {
    DBHandlerAccount dbHandlerAccount;

    public JavaBank() {
        Locale.setDefault(Locale.US);

        dbHandlerAccount = new DBHandlerAccount();
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
                            @WebParam(name="receiverBic") String receiverBic) {
        
    }
}
