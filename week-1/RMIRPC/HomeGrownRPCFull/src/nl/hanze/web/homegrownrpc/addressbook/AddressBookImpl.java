package nl.hanze.web.homegrownrpc.addressbook;

import java.util.*;

public class AddressBookImpl implements AddressBook {
    private ArrayList<Student> students;

    public AddressBookImpl() {
        students=new ArrayList<Student>();
    }

    public void addStudent(Student student) throws Exception {
        students.add(student);
    }

    public boolean removeStudent(int stdNummer) throws Exception {
        for(int i=0;i<students.size();i++) {
            Student student=students.get(i);
            if (student.getStdNummer()==stdNummer) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Student> getAllStudentsAsList() throws Exception {
        return students;
    }

    public Student[] getAllStudentsAsArray() throws Exception {
        return students.toArray(new Student[0]);
    }

    public int countStudents() throws Exception {
        return students.size();
    }
}
