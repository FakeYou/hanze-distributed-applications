package nl.hanze.web.gba.domain;

public interface NatuurlijkPersoonDAO {
    public NatuurlijkPersoon getNatuurlijkPersoonByBSN(long bsn);
    public int addNatuurlijkPersoon(long bs, String geslacht, String initialen, String achternaam, int nummer, String postcode, String woonplaats);
}
