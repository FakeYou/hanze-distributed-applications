package javabank.Models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;
import java.util.Calendar;

@XmlRootElement(name = "Transaction")
@XmlType(propOrder = {"date", "senderBic", "receiverBic", "amount"})
public class Transaction {

    public static final String column_id = "id";
    public static final String column_sender_account_number = "sender_account_number";
    public static final String column_receiver_account_number = "receiver_account_number";
    public static final String column_date = "date";
    public static final String column_amount = "amount";

    private Date date;
    private float amount;
    private String senderBic;
    private String receiverBic;

    public Transaction(){

    }

    public Transaction(String sender_bic, String receiver_bic, float amount) {
        this.senderBic = sender_bic;
        this.receiverBic = receiver_bic;
        this.amount = amount;
        this.date = new Date(Calendar.getInstance().getTime().getTime());
    }

    public String getSenderBic() {
        return senderBic;
    }

    public void setSenderBic(String senderBic) {
        this.senderBic = senderBic;
    }

    public String getReceiverBic() {
        return receiverBic;
    }

    public void setReceiverBic(String receiverBic) {
        this.receiverBic = receiverBic;
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

}
