package nl.hanze.web.homegrownrpc.hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import nl.hanze.web.homegrownrpc.generic.Stub;

import org.apache.commons.codec.binary.Base64;

public class HelloStub implements Hello, Stub {
    private String strIP;
    private int port;
	
    public void setSkelLocation(String strIP, int port) throws Exception {
        this.strIP=strIP;
        this.port=port;
    }

    public String sayHello() throws Exception {
        Socket socHelloStub=new Socket(strIP, port);
        OutputStreamWriter oswHelloStub=new OutputStreamWriter(socHelloStub.getOutputStream());
        BufferedReader bufHelloStub=new BufferedReader(new InputStreamReader(socHelloStub.getInputStream()));
        oswHelloStub.write("sayHello#0\n");
        oswHelloStub.flush();
        String strResult=bufHelloStub.readLine();
        String value=new String(Base64.decodeBase64(strResult.split("#")[1]));
        
        return value;
    }

    public String sayHello(String name) throws Exception {
        Socket socHelloStub=new Socket(strIP, port);
        OutputStreamWriter oswHelloStub=new OutputStreamWriter(socHelloStub.getOutputStream());
        BufferedReader bufHelloStub=new BufferedReader(new InputStreamReader(socHelloStub.getInputStream()));
        String param1=Base64.encodeBase64String(name.getBytes());
        oswHelloStub.write("sayHello#1#java.lang.String#"+param1+"\n");
        oswHelloStub.flush();
        String strResult=bufHelloStub.readLine();
        String value=new String(Base64.decodeBase64(strResult.split("#")[1]));
        
        return value;
    }

    /**
     * Week 2, opgave 2e.
     */
    public String sayHello(int age) throws Exception {
        Socket socHelloStub=new Socket(strIP, port);
        OutputStreamWriter oswHelloStub=new OutputStreamWriter(socHelloStub.getOutputStream());
        BufferedReader bufHelloStub=new BufferedReader(new InputStreamReader(socHelloStub.getInputStream()));
        String param1=Integer.toString(age);
        oswHelloStub.write("sayHello#1#int#"+param1+"\n");
        oswHelloStub.flush();
        String strResult=bufHelloStub.readLine();
        String value=new String(Base64.decodeBase64(strResult.split("#")[1]));

        return value;
    }

    public String sayHello(String name, int age) throws Exception {
        Socket socHelloStub=new Socket(strIP, port);
        OutputStreamWriter oswHelloStub=new OutputStreamWriter(socHelloStub.getOutputStream());
        BufferedReader bufHelloStub=new BufferedReader(new InputStreamReader(socHelloStub.getInputStream()));
        String param1=Base64.encodeBase64String(name.getBytes());
        String param2=Integer.toString(age);
        oswHelloStub.write("sayHello#2#java.lang.String#int#"+param1+"#"+param2+"\n");
        oswHelloStub.flush();
        String strResult=bufHelloStub.readLine();
        String value=new String(Base64.decodeBase64(strResult.split("#")[1]));

        return value;
    }

    public int ageNextYear(int age) throws Exception {
        Socket socHelloStub=new Socket(strIP, port);
        OutputStreamWriter oswHelloStub=new OutputStreamWriter(socHelloStub.getOutputStream());
        BufferedReader bufHelloStub=new BufferedReader(new InputStreamReader(socHelloStub.getInputStream()));
        String param1=Integer.toString(age);
        oswHelloStub.write("ageNextYear#1#int#"+param1+"\n");
        oswHelloStub.flush();
        String strResult=bufHelloStub.readLine();
        int value=Integer.parseInt(strResult.split("#")[1]);

        return value;
    }
}