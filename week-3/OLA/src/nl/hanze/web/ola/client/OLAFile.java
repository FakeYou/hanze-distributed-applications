package nl.hanze.web.ola.client;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class OLAFile {
    private long ref;
    private int euro;
    private int cent;
    private String betalingsKenmerk;
    private String rekeningNummer;

    private String geslacht;
    private String initialen;
    private String achternaam;

    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String plaats;

    private String rekeningNummerNaar;
    private String naamNaar;

    public OLAFile(long ref, int euro, int cent,
                      String betalingsKenmerk, String rekeningNummer,
                      String geslacht, String initialen, String achternaam,
                      String straatnaam, String huisnummer, String postcode, String plaats,
                      String rekeningNummerNaar, String naamNaar) {

        this.ref = ref;
        this.euro = euro;
        this.cent = cent;

        this.betalingsKenmerk = betalingsKenmerk;
        this.rekeningNummer = rekeningNummer;

        this.geslacht = geslacht;
        this.initialen = initialen;
        this.achternaam = achternaam;

        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;

        this.rekeningNummerNaar = rekeningNummerNaar;
        this.naamNaar = naamNaar;
    }

    public InputStream getInputStream() {
        StringBuilder builder = new StringBuilder();

        builder.append("REFERENCE=" + this.ref + "\n");
        builder.append("BEDRAG=" + this.euro + "," + this.cent + "\n");
        builder.append("BETALINGSKENMERK=" + this.betalingsKenmerk + "\n");
        builder.append("REKENINGNUMMER=" + this.rekeningNummer + "\n");
        builder.append("GESLACHT=" + this.geslacht + "\n");
        builder.append("INIT=" + this.initialen + "\n");
        builder.append("ACHTERNAAM=" + this.achternaam + "\n");
        builder.append("STRAATNAAM=" + this.straatnaam + "\n");
        builder.append("STRAATNUMMER=" + this.huisnummer + "\n");
        builder.append("POSTCODE=" + this.postcode + "\n");
        builder.append("PLAATSNAAM=" + this.plaats + "\n");
        builder.append("REKENINGNUMMERNAAR=" + this.rekeningNummer + "\n");
        builder.append("NAAMNAAR=" + this.naamNaar + "\n");

        String ola = builder.toString();

        return new ByteArrayInputStream(ola.getBytes(StandardCharsets.UTF_8));
    }

    public long getRef() {
        return ref;
    }
}
