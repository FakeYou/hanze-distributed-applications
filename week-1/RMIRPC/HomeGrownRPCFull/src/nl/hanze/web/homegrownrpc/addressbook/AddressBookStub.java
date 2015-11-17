package nl.hanze.web.homegrownrpc.addressbook;

import java.util.List;

public class AddressBookStub extends nl.hanze.web.homegrownrpc.generic.Stub implements nl.hanze.web.homegrownrpc.addressbook.AddressBook {

    public void addStudent(Student student) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean removeStudent(int stdNummer) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Student> getAllStudentsAsList() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Student[] getAllStudentsAsArray() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int countStudents() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
