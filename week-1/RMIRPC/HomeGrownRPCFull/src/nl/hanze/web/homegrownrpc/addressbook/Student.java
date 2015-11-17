package nl.hanze.web.homegrownrpc.addressbook;

public class Student {
    private int stdNummer;
    private String name;

    public Student(int stdNummer, String name) {
        this.stdNummer=stdNummer;
        this.name=name;
    }

    public int getStdNummer() {
        return stdNummer;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return stdNummer+" --> "+name;
    }
}
