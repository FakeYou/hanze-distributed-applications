package javabank.DBHandlers;

import javabank.Models.Transaction;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lasse on 4-12-2015.
 */
public class DBHandlerTransaction {

    private DBHandler dbHandler;

    public DBHandlerTransaction() {
        dbHandler = new DBHandler();
    }

    public int addTransaction(Transaction transaction) {
        int rowId = -1;

        String queryAddTransaction = String.format("INSERT INTO transactions (sender_account_number, receiver_account_number, date, amount) " +
                        "VALUES ('%s', '%s', '%s', %f)",
                transaction.getSender_bic(), transaction.getReceiver_bic(), transaction.getDate(), transaction.getAmount());
        rowId = dbHandler.add(queryAddTransaction);

        return rowId;
    }

    public ArrayList<Transaction> getTransactions(String bic, String date) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        java.sql.Date sqlStartDate = null;
        //Convert String date to SQL date
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date sqlDate = format.parse(date);
            sqlStartDate = new java.sql.Date(sqlDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String queryAddAccount = String.format("SELECT * FROM transactions WHERE sender_account_number='%s' AND date='%s'", bic, sqlStartDate);
        List<HashMap> resultList = dbHandler.getMany(queryAddAccount);

        for (HashMap resultMap : resultList) {
            try {
                Transaction transaction = new Transaction();
                transaction.setDate((Date) resultMap.get(Transaction.column_date));
                transaction.setReceiver_bic((String) resultMap.get(Transaction.column_receiver_account_number));
                transaction.setSender_bic((String) resultMap.get(Transaction.column_sender_account_number));
                transaction.setAmount((Float) resultMap.get(Transaction.column_amount));

                transactions.add(transaction);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return transactions;
    }
}
