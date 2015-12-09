package javabank.Models;

import java.sql.Date;

/**
 * Created by Lasse on 4-12-2015.
 */
public class Transaction {

    public static final String column_id = "id";
    public static final String column_sender_account_number = "sender_account_number";
    public static final String column_receiver_account_number = "receiver_account_number";
    public static final String column_date = "date";
    public static final String column_amount = "amount";

    private String sender_bic;
    private String receiver_bic;

    public Transaction(){

    }

    public String getSender_bic() {
        return sender_bic;
    }

    public void setSender_bic(String sender_bic) {
        this.sender_bic = sender_bic;
    }

    public String getReceiver_bic() {
        return receiver_bic;
    }

    public void setReceiver_bic(String receiver_bic) {
        this.receiver_bic = receiver_bic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    private Date date;
    private float amount;




}
