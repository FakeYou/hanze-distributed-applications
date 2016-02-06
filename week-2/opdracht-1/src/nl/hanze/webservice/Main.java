package nl.hanze.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.getStudent("andre"));
    }

    @WebMethod
    @WebResult(name="Student")
    public Student getStudent(@WebParam(name="naam") String naam) {
        Student student = new Student();

        student.setNaam(naam);
        student.setLeeftijd(20);
        student.setGeslacht(true);

        return student;
    }
}
