package nl.hanze.web.homegrownrpc.generic;

import java.net.*;
import java.util.*;
import java.io.*;

@SuppressWarnings("rawtypes")
public class NameServer {
    private ServerSocket ssoNameServer;
    private HashMap<String, Class> hsmServerClass;
    private HashMap<String, String> hsmServerIP;
    private HashMap<String, Integer> hsmServerPort;

    public NameServer(int port) throws Exception {
        ssoNameServer = new ServerSocket(port);
        hsmServerClass=new HashMap<String, Class>();
        hsmServerIP=new HashMap<String, String>();
        hsmServerPort=new HashMap<String, Integer>();
    }

    public void listenAndHandle() throws Exception {
        System.out.println ("Nameserver waiting for requests...");

        while (true) {
            Socket socNameServiceUser = ssoNameServer.accept();
            ObjectInputStream ois=new ObjectInputStream(socNameServiceUser.getInputStream());
            ObjectOutputStream ous=new ObjectOutputStream(socNameServiceUser.getOutputStream());
            String command=(String) ois.readObject();
            String name=(String) ois.readObject();

            if (command.equals("PUT")) {
                Class c=(Class) ois.readObject();
                hsmServerClass.put(name, c);
                String serverIP=(String) ois.readObject();
                hsmServerIP.put(name, serverIP);
                int serverPort=ois.readInt();
                hsmServerPort.put(name, serverPort);
                ous.writeObject("OK");
            } else {
                Class c=hsmServerClass.get(name);
                ous.writeObject(c);
                String serverIP=hsmServerIP.get(name);
                ous.writeObject(serverIP);
                int serverPort=hsmServerPort.get(name);
                ous.writeInt(serverPort);
            }
            ous.close();
            ois.close();
            socNameServiceUser.close();
        }
    }
    public static void main(String[] args) {
        try {
            NameServer s = new NameServer(7090);
            s.listenAndHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}