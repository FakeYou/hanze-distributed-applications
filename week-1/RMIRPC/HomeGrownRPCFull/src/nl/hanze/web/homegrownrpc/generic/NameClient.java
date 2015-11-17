package nl.hanze.web.homegrownrpc.generic;

import java.net.*;
import java.io.*;


@SuppressWarnings("rawtypes")
public class NameClient {
    private String strIP;
    private int port;

    public NameClient(String strIP, int port) {
        this.strIP = strIP;
        this.port = port;
    }

    public Stub getReference(String strName) throws Exception {
        Socket socNameClient = new Socket(this.strIP, this.port);
        ObjectOutputStream oos=new ObjectOutputStream(socNameClient.getOutputStream());
        ObjectInputStream ois=new ObjectInputStream(socNameClient.getInputStream());
        oos.writeObject("GET");
        oos.writeObject(strName);
        oos.flush();
		Class c=(Class) ois.readObject();
        Stub stub=null;
        if (c!=null) {
            stub=(Stub) c.newInstance();
            String serverIP=(String) ois.readObject();
            int serverPort=ois.readInt();
            stub.setSkelLocation(serverIP, serverPort);
        }
        ois.close();
        oos.close();
        socNameClient.close();
        return stub;
    }

    public void setReference(String strServerName, String strStubName, String strServerIP, int port) throws Exception {
        Class c=Class.forName(strStubName);
        Socket socNameClient = new Socket(this.strIP, this.port);
        ObjectOutputStream oos=new ObjectOutputStream(socNameClient.getOutputStream());
        ObjectInputStream ois=new ObjectInputStream(socNameClient.getInputStream());
        oos.writeObject("PUT");
        oos.writeObject(strServerName);
        oos.writeObject(c);
        oos.writeObject(strServerIP);
        oos.writeInt(port);
        oos.flush();
        ois.readObject();
    }
}