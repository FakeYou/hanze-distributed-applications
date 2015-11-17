package nl.hanze.web.homegrownrpc.hello;

import nl.hanze.web.homegrownrpc.generic.*;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        Hello hsvHello=new HelloImpl();
        NameClient nc=new NameClient("localhost", 7090);
        nc.setReference("HelloServer", "nl.hanze.web.homegrownrpc.hello.HelloStub", "localhost", 8800);
        Skel hskHello=new Skel();
        hskHello.setPort(8800);
        hskHello.setImplementation(hsvHello);
        hskHello.listen();
    }
}