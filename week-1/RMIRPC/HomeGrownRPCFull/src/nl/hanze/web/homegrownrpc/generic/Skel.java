package nl.hanze.web.homegrownrpc.generic;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;


@SuppressWarnings("rawtypes")
public class Skel {
    private int port;
    private Object obj;
    private ServerSocket ssoSkel;

    public void setPort(int port) {
        this.port=port;
    }

    public void setImplementation(Object obj) {
        this.obj=obj;
    }

    public void listen() throws Exception {
        ssoSkel = new ServerSocket(port);

        while(true) {
            invokeMethod(ssoSkel.accept());
        }
    }

    private void invokeMethod(Socket s) throws Exception {
        ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
        String methodName=(String) ois.readObject();
        Class[] parameterTypes=(Class[]) ois.readObject();
        Object[] parameterValues=(Object[]) ois.readObject();
        Method method=obj.getClass().getMethod(methodName, parameterTypes);
        Object returnValue=method.invoke(obj, parameterValues);
        String retType=method.getReturnType().getName();

        ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());

        if (retType.equals("void")) {
            oos.writeBoolean(true);
            oos.flush();
            oos.close();
            s.close();
            return;
        } else {
            oos.writeBoolean(false);
            oos.writeObject(method.getReturnType());
            if (method.getReturnType().isPrimitive()) {
                if (retType.equals("boolean")) {
                    oos.writeBoolean(((java.lang.Boolean) returnValue).booleanValue());
                }
                if (retType.equals("byte")) {
                    oos.writeByte(((java.lang.Byte) returnValue).byteValue());
                }
                if (retType.equals("char")) {
                    oos.writeChar(((java.lang.Character) returnValue).charValue());
                }
                if (retType.equals("double")) {
                    oos.writeDouble(((java.lang.Double) returnValue).doubleValue());
                }
                if (retType.equals("float")) {
                    oos.writeFloat(((java.lang.Float) returnValue).floatValue());
                }
                if (retType.equals("int")) {
                    oos.writeInt(((java.lang.Integer) returnValue).intValue());
                }
                if (retType.equals("long")) {
                    oos.writeLong(((java.lang.Long) returnValue).longValue());
                }
                if (retType.equals("short")) {
                    oos.writeShort(((java.lang.Short) returnValue).shortValue());
                }
            } else {
                oos.writeObject(returnValue);
            }

            oos.flush();
            oos.close();
            s.close();
        }
    }
}