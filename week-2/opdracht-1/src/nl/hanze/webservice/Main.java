package nl.hanze.webservice;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.setNaam("Andre");
        student.setLeetijd(24);
        student.setGeslacht(true);

        System.out.println(student.toXML());
    }
}
