package javabank.Models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Account")
@XmlType(propOrder = {"name", "bic", "credit"})
public class Account {

    private String name;
    private String city;
    private String address;
    private String bic;
    private float credit;
    private float limit;
    private float balance;

    // Database column names
    public static final String column_balance_amount = "balance_amount";
    public static final String column_account_number = "account_number";
    public static final String column_name = "name";
    public static final String column_address = "address";
    public static final String column_city = "city";
    public static final String column_limit_amount = "limit_amount";



    public Account() {

    }

    public Account(String name, String bic) {
        this.name = name;
        this.bic = bic;
        this.credit = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLimit() {
        return limit;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
