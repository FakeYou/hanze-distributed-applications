package nl.hanze.web.homegrownrpc.generic;

import java.lang.reflect.*;
import java.io.*;
import java.util.*;

public class StubGenerator {
    private StringBuffer stbTemp;
    private String fullInterfaceName;
    private String nameStub;
    private String packageStub;
    private String locationStub;
    private HashMap<String, String> wrapperClass;

    public StubGenerator(String fullInterfaceName, String baseLocationStub) {
        this.fullInterfaceName=fullInterfaceName;
        this.nameStub=getInterfaceName()+"Stub";
        this.packageStub=getPackageName(false);
        this.locationStub=baseLocationStub+File.separatorChar+getPackageName(true);
        wrapperClass=new HashMap<String, String>();
        wrapperClass.put("boolean", "java.lang.Boolean");
    }

    public void generateStub() throws Exception {
        stbTemp=new StringBuffer();
        generatePackageName();
        generateEmptyLine();
        generateClassLine();
        Method[] methods=searchMethods();
        for(Method method : methods) {
            generateEmptyLine();
            generateMethod(method);
        }
        generateEmptyLine();
        generateLastLine();
        saveGeneratedClass();
    }

    private void generatePackageName() {
        if (packageStub!=null && packageStub.length()!=0) {

        }
    }

    private void generateClassLine() {
        stbTemp.append("public class ");
        stbTemp.append(nameStub);
        stbTemp.append(" extends nl.hanze.web.homegrownrpc.generic.Stub");

    }

    private Method[] searchMethods() throws Exception {
        return null;
    }

    private void generateMethod(Method method) {
        String returnType=method.getReturnType().getCanonicalName();
        boolean isPrimitive=wrapperClass.containsKey(returnType);
        boolean isVoid=returnType.equals("void");
        String methodName=method.getName();
        Class[] params=method.getParameterTypes();
        boolean hasParameters=params.length!=0;
    }

    private void generateEmptyLine() {
        stbTemp.append("\n");
    }

    private void generateLastLine() {
        stbTemp.append("}\n");
    }

    private void saveGeneratedClass() throws Exception {
        File file=new File(locationStub);
        file.mkdirs();
    }

    private String getInterfaceName() {
        int i=fullInterfaceName.lastIndexOf('.');
        if (i==-1) return fullInterfaceName;
        i++;
        return fullInterfaceName.substring(i);
    }

    private String getPackageName(boolean useSlashes) {
        int i=fullInterfaceName.lastIndexOf('.');
        if (i==-1) return "";
        if (useSlashes)
            return fullInterfaceName.substring(0,i).replace('.', File.separatorChar);
        else
            return fullInterfaceName.substring(0,i);
    }

    public static void main(String[] args) throws Exception {
        StubGenerator sg=new StubGenerator("nl.hanze.web.homegrownrpc.addressbook.AddressBook", "C:\\Temp");
        sg.generateStub();
    }

}
