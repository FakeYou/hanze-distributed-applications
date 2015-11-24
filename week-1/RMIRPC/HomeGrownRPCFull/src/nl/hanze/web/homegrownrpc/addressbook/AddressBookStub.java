package nl.hanze.web.homegrownrpc.addressbook;

import java.util.List;

public class AddressBookStub extends nl.hanze.web.homegrownrpc.generic.Stub implements nl.hanze.web.homegrownrpc.addressbook.AddressBook {

    public void addStudent(Student student) throws Exception {
        invokeSkel("addStudent", new Class[] {Student.class}, new Object[] {student});
    }

    public boolean removeStudent(int stdNummer) throws Exception {
        Object obj = invokeSkel("removeStudent", new Class[] {int.class}, new Object[] {stdNummer});

        return ((Boolean) obj).booleanValue();
    }

    public List<Student> getAllStudentsAsList() throws Exception {
        Object obj = invokeSkel("getAllStudentsAsList", null, null);

        return (List<Student>) obj;
    }

    public Student[] getAllStudentsAsArray() throws Exception {
        Object obj = invokeSkel("getAllStudentsAsArraya", null, null);

        return (Student[]) obj;
    }

    public int countStudents() throws Exception {
        Object obj = invokeSkel("countStudents", null, null);

        return ((Integer) obj).intValue();
    }

}
