package nl.hanze.web.gba;

import nl.hanze.web.gba.domain.NatuurlijkPersoon;
import nl.hanze.web.gba.domain.NatuurlijkPersoonDAOImpl;

public class Main {
    public static void main(String[] args) {
        NatuurlijkPersoonDAOImpl impl = new NatuurlijkPersoonDAOImpl();
        NatuurlijkPersoon np = impl.getNatuurlijkPersoonByBSN(128376874681l);

        System.out.println(np);
    }
}
