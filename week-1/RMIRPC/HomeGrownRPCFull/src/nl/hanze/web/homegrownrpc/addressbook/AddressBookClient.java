package nl.hanze.web.homegrownrpc.addressbook;

import nl.hanze.web.homegrownrpc.generic.*;
import java.util.*;

public class AddressBookClient {
    public static void main(String[] args) throws Exception {
        NameClient nc=new NameClient("localhost", 7090);
        AddressBook ab = (AddressBook) nc.getReference("AddressBookServer");
        System.out.println("We obtained "+ab+" that implements AddressBook");

        Student s1=new Student(12345, "Chris");
        Student s2=new Student(23456, "Bart");
        ab.addStudent(s1);
        ab.addStudent(s2);

        List<Student> students1=ab.getAllStudentsAsList();

        for(Student student : students1)
            System.out.println(student);

        System.out.println(ab.removeStudent(34567));
        System.out.println(ab.removeStudent(12345));

        Student s3=new Student(45678, "Henri");
        Student s4=new Student(56789, "Gideon");
        ab.addStudent(s3);
        ab.addStudent(s4);

        Student[] students2=ab.getAllStudentsAsArray();

        for(Student student : students2) {
            System.out.println(student);
        }
    }
}
