package nl.hanze.web.homegrownrpc.addressbook;

import nl.hanze.web.homegrownrpc.generic.*;

public class AddressBookServer {
    public static void main(String[] args) throws Exception {
        AddressBook ab=new AddressBookImpl();
        NameClient nc=new NameClient("localhost", 7090);
        nc.setReference("AddressBookServer", "nl.hanze.web.homegrownrpc.addressbook.AddressBookStub", "localhost", 8801);
        Skel hskHello=new Skel();
        hskHello.setPort(8801);
        hskHello.setImplementation(ab);
        hskHello.listen();
    }
}
