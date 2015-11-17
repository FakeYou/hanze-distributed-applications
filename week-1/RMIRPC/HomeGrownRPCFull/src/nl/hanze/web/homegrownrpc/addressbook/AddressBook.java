package nl.hanze.web.homegrownrpc.addressbook;

import java.util.*;

public interface AddressBook {
    public void addStudent(Student student) throws Exception;
    public boolean removeStudent(int stdNummer) throws Exception;
    public List<Student> getAllStudentsAsList() throws Exception;
    public Student[] getAllStudentsAsArray() throws Exception;
    public int countStudents() throws Exception;
}
