package nl.hanze.web.homegrownrpc.addressbook;

public class AddressBookStub extends nl.hanze.web.homegrownrpc.generic.Stub implements nl.hanze.web.homegrownrpc.addressbook.AddressBook {

    public void addStudent(nl.hanze.web.homegrownrpc.addressbook.Student arg0) throws Exception {
        Object obj = invokeSkel("addStudent", new java.lang.Class[] {nl.hanze.web.homegrownrpc.addressbook.Student.class}, new java.lang.Object[] {arg0});
    }

    public boolean removeStudent(int arg0) throws Exception {
        Object obj = invokeSkel("removeStudent", new java.lang.Class[] {int.class}, new java.lang.Object[] {arg0});
        return (boolean) obj;
    }

    public int countStudents () throws Exception {
        Object obj = invokeSkel("countStudents", null, null);
        return (int) obj;
    }

    public nl.hanze.web.homegrownrpc.addressbook.Student[] getAllStudentsAsArray () throws Exception {
        Object obj = invokeSkel("getAllStudentsAsArray", null, null);
        return (nl.hanze.web.homegrownrpc.addressbook.Student[]) obj;
    }

    public java.util.List getAllStudentsAsList () throws Exception {
        Object obj = invokeSkel("getAllStudentsAsList", null, null);
        return (java.util.List) obj;
    }

}
