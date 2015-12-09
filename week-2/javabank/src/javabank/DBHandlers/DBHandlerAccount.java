package javabank.DBHandlers;

import javabank.Models.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lasse on 4-12-2015.
 */

public class DBHandlerAccount extends DBHandler {

    private DBHandler dbHandler;

    public DBHandlerAccount() {
        dbHandler = new DBHandler();

    }

    public int addAccount(Account account) {
        int rowId = -1;

        String queryAddAccount = String.format("INSERT INTO accounts (balance_amount, account_number, name, address, city, limit_amount ) " +
                        "VALUES (%f, '%s', '%s', '%s', '%s', %f)",
                account.getBalance(), account.getBic(), account.getName(), account.getAddress(), account.getCity(), account.getLimit());
        dbHandler.add(queryAddAccount);

        if (rowId != -1) {
            return rowId;
        }

        return rowId;
    }

    public Account getAccount(String accountNumber) {
        HashMap resultMap = new HashMap();
        String queryAddAccount = String.format("SELECT * FROM accounts WHERE account_number='%s'", accountNumber);
        resultMap = dbHandler.get(queryAddAccount);

        Account account = new Account();

        try {
            account.setBalance((Float) resultMap.get(Account.column_balance_amount));
            account.setBic((String) resultMap.get(Account.column_account_number));
            account.setName((String) resultMap.get(Account.column_name));
            account.setAddress((String) resultMap.get(Account.column_address));
            account.setCity((String) resultMap.get(Account.column_city));
            account.setLimit((Float) resultMap.get(Account.column_limit_amount));

            }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return account;
    }

    public int getAccountId(Account account){
        int accountId = -1;
        HashMap resultMap = new HashMap();
        String queryGetAccountId= String.format("SELECT id FROM accounts WHERE account_number='%s'", account.getBic());
        resultMap = dbHandler.get(queryGetAccountId);

       accountId = (int) resultMap.get("id");

        return accountId;
    }

    public int updateAccount(Account account){
        int rowId = -1;

        rowId = getAccountId(account);

        String queryAddAccount = String.format("UPDATE accounts SET balance_amount= %f, account_number= '%s', name='%s', " +
                "address='%s', city='%s', limit_amount=%f WHERE id=%d",
                account.getBalance(), account.getBic(), account.getName(), account.getAddress(),
                account.getCity(), account.getLimit(), rowId);

        dbHandler.add(queryAddAccount);

        if (rowId != -1) {
            return rowId;
        }

        return rowId;
    }
}
