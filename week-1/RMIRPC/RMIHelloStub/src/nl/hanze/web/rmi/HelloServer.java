package nl.hanze.web.rmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        Hello hello=new HelloImpl();
        Naming.rebind("rmi://localhost:1099/HelloService", hello);
    }
}

