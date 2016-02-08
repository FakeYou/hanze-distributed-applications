package nl.hanze.web.gba.domain;

public class NatuurlijkPersoon {
    private long bsn;
    private char geslacht;
    private String initialen;
    private String achternaam;
    private int nummer;
    private String postcode;
    private String woonplaats;

    public NatuurlijkPersoon() {

    }

    public String toString() {
        return "[NatuurlijkPersoon] " + bsn + ", " + initialen + " " + achternaam;
    }

    public long getBsn() {
        return bsn;
    }

    public void setBsn(long bsn) {
        this.bsn = bsn;
    }

    public char getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(char geslacht) {
        this.geslacht = geslacht;
    }

    public String getInitialen() {
        return initialen;
    }

    public void setInitialen(String initialen) {
        this.initialen = initialen;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}
