package nl.hanze.web.ola;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AcceptGiroFileReader {

    public static AcceptGiro readOla(String file) throws Exception {
        AcceptGiro acceptGiro = new AcceptGiro();

        final Exception[] readException = {null};

        Files.lines(Paths.get(file)).forEach(line -> {
            String key = line.split("=")[0];
            String value = line.split("=")[1];

            try {
                switch (key) {
                    case "REFERENCE":
                        acceptGiro.setRef(Long.parseLong(value));
                        break;
                    case "BEDRAG":
                        acceptGiro.setEuro(Integer.parseInt(value.split(",")[0]));
                        acceptGiro.setCent(Integer.parseInt(value.split(",")[1]));
                        break;
                    case "BETALINGSKENMERK":
                        acceptGiro.setBetalingsKenmerk(value);
                        break;
                    case "REKENINGNUMMER":
                        acceptGiro.setRekeningNummer(value);
                        break;
                    case "GESLACHT":
                        if (value.equals("M")) {
                            acceptGiro.setGeslacht(AcceptGiro.Geslacht.MAN);
                        } else if (value.equals("V")) {
                            acceptGiro.setGeslacht(AcceptGiro.Geslacht.VROUW);
                        }
                        break;
                    case "INIT":
                        acceptGiro.setInitialen(value);
                        break;
                    case "ACHTERNAAM":
                        acceptGiro.setAchternaam(value);
                        break;
                    case "STRAATNAAM":
                        acceptGiro.setStraatnaam(value);
                        break;
                    case "STRAATNUMMER":
                        acceptGiro.setHuisnummer(value);
                        break;
                    case "POSTCODE":
                        acceptGiro.setPostcode(value);
                        break;
                    case "PLAATSNAAM":
                        acceptGiro.setPlaats(value);
                        break;
                    case "REKENINGNUMMERNAAR":
                        acceptGiro.setRekeningNummerNaar(value);
                        break;
                    case "NAAMNAAR":
                        acceptGiro.setNaamNaar(value);
                        break;
                }
            }
            catch(Exception e) {
                readException[0] = e;
            }
        });

        if(readException[0] != null) {
            throw readException[0];
        }

        return acceptGiro;
    }
}
