package nl.hanze.web.gba.domain;

import nl.hanze.web.gba.db.DBHandler;

import java.util.HashMap;

public class NatuurlijkPersoonDAOImpl implements NatuurlijkPersoonDAO {
    @Override
    public NatuurlijkPersoon getNatuurlijkPersoonByBSN(long bsn) {
        NatuurlijkPersoon natuurlijkPersoon = new NatuurlijkPersoon();
        DBHandler dbHandler = new DBHandler();

        String query = String.format("SELECT * FROM `GBA`.`natuurlijkpersonen` WHERE bsn=%s", bsn);
        System.out.println(query);

        HashMap results = dbHandler.get(query);
        System.out.println(results);

        if(results.size() == 0) {
            natuurlijkPersoon.setBsn(-1);
            return natuurlijkPersoon;
        }

        natuurlijkPersoon.setBsn((Long) results.get("bsn"));
        natuurlijkPersoon.setGeslacht(((String) results.get("geslacht")).charAt(0));
        natuurlijkPersoon.setInitialen((String) results.get("initialen"));
        natuurlijkPersoon.setAchternaam((String) results.get("achternaam"));
        natuurlijkPersoon.setNummer((Integer) results.get("nummer"));
        natuurlijkPersoon.setPostcode((String) results.get("postcode"));
        natuurlijkPersoon.setWoonplaats((String) results.get("woonplaats"));

        return natuurlijkPersoon;
    }
}
