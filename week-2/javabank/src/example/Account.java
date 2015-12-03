package example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="account")
public class Account {

    private String name;
    private String bic;
    private int credit;

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
}
