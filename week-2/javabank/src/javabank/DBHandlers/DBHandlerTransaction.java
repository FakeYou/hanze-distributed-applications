package javabank.DBHandlers;

import javabank.Models.Transaction;

/**
 * Created by Lasse on 4-12-2015.
 */
public class DBHandlerTransaction {

    private DBHandler dbHandler;

    public DBHandlerTransaction(){
        dbHandler = new DBHandler();
    }

    public int addTransaction(Transaction transaction) {
        int rowId = -1;

        String queryAddTransaction = String.format("INSERT INTO transactions (sender_account_number, receiver_account_number, date, amount) " +
                        "VALUES ('%s', '%s', '%s', %f)",
                transaction.getSenderBic(), transaction.getReceiverBic(), transaction.getDate(), transaction.getAmount());
        rowId = dbHandler.add(queryAddTransaction);

        return rowId;
    }


}
