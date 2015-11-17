package nl.hanze.web.homegrownrpc.generic;

import java.net.*;
import java.io.*;

@SuppressWarnings("rawtypes")
public class Stub {
    private String strIP;
    private int port;

    public void setSkelLocation(String strIP, int port) throws Exception {
        this.strIP=strIP;
        this.port=port;
    }

    protected Object invokeSkel(String methodName, Class[] parameterTypes, Object[] parameterValues) throws Exception {
        if (parameterTypes!=null && parameterValues!=null) {
            if (parameterTypes.length!=parameterValues.length) {
                throw new Exception("Bad parameters");
            }
        }

        if (parameterTypes!=null ^ parameterValues!=null) {
            throw new Exception("Bad parameters");
        }

        Socket socStub=new Socket(strIP, port);
        ObjectOutputStream oos=new ObjectOutputStream(socStub.getOutputStream());
        oos.writeObject(methodName);
        oos.writeObject(parameterTypes);
        oos.writeObject(parameterValues);

        oos.flush();

        Object result=null;

        ObjectInputStream ois=new ObjectInputStream(socStub.getInputStream());
        boolean resultVoid=ois.readBoolean();

        if (resultVoid) {
            result=null;
        } else {
            Class resultType = (Class) ois.readObject();
            if (resultType.isPrimitive()) {
                String primitiveTypeName=resultType.getName();
                if (primitiveTypeName.equals("boolean")) {
                    result=ois.readBoolean();
                }

                if (primitiveTypeName.equals("byte")) {
                    result=ois.readByte();
                }

                if (primitiveTypeName.equals("char")) {
                    result=ois.readChar();
                }

                if (primitiveTypeName.equals("double")) {
                    result=ois.readDouble();
                }

                if (primitiveTypeName.equals("float")) {
                    result=ois.readFloat();
                }

                if (primitiveTypeName.equals("int")) {
                    result=ois.readInt();
                }

                if (primitiveTypeName.equals("long")) {
                    result=ois.readLong();
                }

                if (primitiveTypeName.equals("short")) {
                    result=ois.readShort();
                }
            } else {
                result=ois.readObject();
            }
        }

        return result;
    }

}