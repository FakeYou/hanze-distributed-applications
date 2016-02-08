package nl.hanze.web.ola;

public class AcceptGiro {
    private long ref;
    private int euro;
    private int cent;
    private String betalingsKenmerk;
    private String rekeningNummer;

    private Geslacht geslacht;
    private String initialen;
    private String achternaam;

    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String plaats;

    private String rekeningNummerNaar;
    private String naamNaar;

    public enum Geslacht {
        MAN, VROUW
    };

    public AcceptGiro() {

    }

    public AcceptGiro(long ref, int euro, int cent,
                      String betalingsKenmerk, String rekeningNummer,
                      Geslacht geslacht, String initialen, String achternaam,
                      String straatnaam, String huisnummer, String postcode, String plaats,
                      String rekeningNummerNaar, String naamNaar) throws Exception {

        setRef(ref);
        setEuro(euro);
        setCent(cent);

        setBetalingsKenmerk(betalingsKenmerk);
        setRekeningNummer(rekeningNummer);

        setGeslacht(geslacht);
        setInitialen(initialen);
        setAchternaam(achternaam);

        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setPlaats(plaats);

        setRekeningNummerNaar(rekeningNummerNaar);
        setNaamNaar(naamNaar);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("---- Ref: " + ref + " ----");
        builder.append("\n");
        builder.append("€" + euro + "," + cent);
        builder.append(" van " + rekeningNummer + " naar " + rekeningNummerNaar);
        builder.append("\n");
        builder.append("Kenmerk: " + getBetalingsKenmerk());
        builder.append("\n");
        builder.append(getNaam() + ", " + getAdresPC());

        return builder.toString();
    }

    public long getRef() {
        return ref;
    }

    public void setRef(long ref) {
        this.ref = ref;
    }

    public int getEuro() {
        return euro;
    }

    public void setEuro(int euro) throws Exception {
        if(AcceptGiroValidator.validEuro(euro)) {
            this.euro = euro;
        }
        else {
            throw new Exception("Invalid euro " + euro);
        }
    }

    public int getCent() {
        return cent;
    }

    public void setCent(int cent) throws Exception {
        if(AcceptGiroValidator.validCent(cent)) {
            this.cent = cent;
        }
        else {
            throw new Exception("Invalid cent " + cent);
        }
    }

    public String getBetalingsKenmerk() {
        return String.join(" ", betalingsKenmerk.split("(?<=\\G....)"));
    }

    public void setBetalingsKenmerk(String betalingsKenmerk) throws Exception {
        if(AcceptGiroValidator.validBetalingsKenmerk(betalingsKenmerk)) {
            this.betalingsKenmerk = betalingsKenmerk;
        }
        else {
            throw new Exception("Invalid betalingsKenmerk " + betalingsKenmerk);
        }
    }

    public String getRekeningNummer() {
        return rekeningNummer;
    }

    public void setRekeningNummer(String rekeningNummer) throws Exception {
        if(AcceptGiroValidator.validRekeningNummer(rekeningNummer)) {
            this.rekeningNummer = rekeningNummer;
        }
        else {
            throw new Exception("Invalid rekeningNummer " + rekeningNummer);
        }
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public String getInitialen() {
        return initialen;
    }

    public void setInitialen(String initialen) throws Exception {
        if(AcceptGiroValidator.validInitialen(initialen)) {
            this.initialen = initialen;
        }
        else {
            throw new Exception("Invalid initialen " + initialen);
        }
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) throws Exception {
        if(AcceptGiroValidator.validAchternaam(achternaam)) {
            this.achternaam = achternaam;
        }
        else {
            throw new Exception("Invalid achternaam " + achternaam);
        }
    }

    public String getNaam() {
        String aanheffing = "";

        if(geslacht == Geslacht.MAN) {
            aanheffing = "Dhr.";
        }
        else {
            aanheffing = "Mvr.";
        }

        return aanheffing + " " + initialen + " " + achternaam;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) throws Exception {
        if(AcceptGiroValidator.validHuisNummer(huisnummer)) {
            this.huisnummer = huisnummer;
        }
        else {
            throw new Exception("Invalid huisnummer " + huisnummer);
        }
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) throws Exception {
        if(AcceptGiroValidator.validPostCode(postcode)) {
            this.postcode = postcode;
        }
        else {
            throw new Exception("Invalid postcode " + postcode);
        }
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getAdresPC() {
        return straatnaam + " " + huisnummer + " " + postcode;
    }

    public String getRekeningNummerNaar() {
        return rekeningNummerNaar;
    }

    public void setRekeningNummerNaar(String rekeningNummerNaar) throws Exception {
        if(AcceptGiroValidator.validRekeningNummerNaar(rekeningNummerNaar)) {
            this.rekeningNummerNaar = rekeningNummerNaar;
        }
        else {
            throw new Exception("Invalid rekeningNummerNaar " + rekeningNummerNaar);
        }
    }

    public String getNaamNaar() {
        return naamNaar;
    }

    public void setNaamNaar(String naamNaar) {
        this.naamNaar = naamNaar;
    }
}
