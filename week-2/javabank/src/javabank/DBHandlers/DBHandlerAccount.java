package javabank.DBHandlers;

import javabank.Models.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Lasse on 4-12-2015.
 */

public class DBHandlerAccount {

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

    public void getAccount(String accountNumber) {
        ResultSet resultSet;

        String queryAddAccount = String.format("SELECT * FROM accounts WHERE account_number='%s'", accountNumber);
        resultSet = dbHandler.get(queryAddAccount);

        Account account = new Account();
    }
}
