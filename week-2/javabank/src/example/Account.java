package example;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Account")
@XmlType(propOrder={"name", "bic", "credit"})
public class Account {

    private String name;
    private String bic;
    private float credit;

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
}
