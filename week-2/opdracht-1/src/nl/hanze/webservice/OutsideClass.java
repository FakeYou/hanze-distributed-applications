package nl.hanze.webservice;

/**
 * Created by Lasse on 25-11-2015.
 */
public class OutsideClass {

    /** Return the serialized Student as a string.
     * @return String: Serialized Student
     */
    public String getStudent(){
        Student student = new Student();
        student.setGeslacht(false);
        student.setLeeftijd(10);
        student.setNaam("Bob");

        return student.toXML();
    }
}
