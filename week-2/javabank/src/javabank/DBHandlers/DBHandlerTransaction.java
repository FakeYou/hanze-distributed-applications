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
                transaction.getSender_bic(), transaction.getReceiver_bic(), transaction.getDate(), transaction.getAmount());
        dbHandler.add(queryAddTransaction);

        if (rowId != -1) {
            return rowId;
        }

        return rowId;
    }


}
