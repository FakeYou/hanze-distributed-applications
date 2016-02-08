package nl.hanze.web.ola;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptGiroValidator {

    public static boolean validEuro(int euro) {
        return euro >= 1 && euro <= 99999;
    }

    public static boolean validCent(int cent) {
        return cent >= 0 && cent <= 99;
    }

    public static boolean validBetalingsKenmerk(String kenmerk) {
        return kenmerk.length() == 16;
    }

    public static boolean validRekeningNummer(String rekeningNummer) {
        return rekeningNummer.length() <= 10;
    }

    public static boolean validInitialen(String initialen) {
        return initialen.length() <= 5;
    }

    public static boolean validAchternaam(String acternaam) {
        return acternaam.length() <= 20;
    }

    public static boolean validHuisNummer(String huisnummer) {
        return huisnummer.length() >= 1;
    }

    public static boolean validPostCode(String postcode) {
        Pattern VALID_POSTCODE = Pattern.compile("^\\d{4} ?[a-zA-Z]{2}$");

        Matcher matcher = VALID_POSTCODE.matcher(postcode);
        return matcher.matches();
    }

    public static boolean validRekeningNummerNaar(String rekeningNummerNaar) {
        return rekeningNummerNaar.length() >= 1 && rekeningNummerNaar.length() <= 10;
    }

}
