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
        wrapperClass.put("byte", "java.lang.Byte");
        wrapperClass.put("char", "java.lang.Character");
        wrapperClass.put("double", "java.lang.Double");
        wrapperClass.put("float", "java.lang.Float");
        wrapperClass.put("int", "java.lang.Integer");
        wrapperClass.put("long", "java.lang.Long");
        wrapperClass.put("short", "java.lang.Short");
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
            stbTemp.append("package ");
            stbTemp.append(packageStub);
            stbTemp.append(";");
            stbTemp.append("\n");
        }
    }

    private void generateClassLine() {
        stbTemp.append("public class ");
        stbTemp.append(nameStub);
        stbTemp.append(" extends nl.hanze.web.homegrownrpc.generic.Stub");
        stbTemp.append(" implements ");
        stbTemp.append(fullInterfaceName);
        stbTemp.append(" {");
        stbTemp.append("\n");
    }

    private Method[] searchMethods() throws Exception {
        Class inter = Class.forName(fullInterfaceName);

        return inter.getMethods();
    }

    private void generateMethod(Method method) {
        String returnType = method.getReturnType().getCanonicalName();
        boolean isPrimitive = wrapperClass.containsKey(returnType);
        boolean isVoid = returnType.equals("void");
        String methodName = method.getName();
        Parameter[] parameters = method.getParameters();
        boolean hasParameters = parameters.length!=0;

        stbTemp.append("\t");
        stbTemp.append("public ");
        stbTemp.append(returnType);
        stbTemp.append(" ");
        stbTemp.append(methodName);

        if(hasParameters) {
            String[] params = new String[parameters.length];

            for(int i = 0; i < parameters.length; i++) {
                params[i] = parameters[i].getType().getName() + " " + parameters[i].getName();
            }

            stbTemp.append("(");
            stbTemp.append(String.join(", ", params));
            stbTemp.append(")");
        }
        else {
            stbTemp.append(" ()");
        }

        stbTemp.append(" throws Exception");

        stbTemp.append(" {\n");

        stbTemp.append("\t\t");
        stbTemp.append("Object obj = invokeSkel(\"");
        stbTemp.append(method.getName());
        stbTemp.append("\", ");

        if(hasParameters) {
            String[] types = new String[parameters.length];
            String[] values = new String[parameters.length];

            for(int i = 0; i < parameters.length; i++) {
                types[i] = parameters[i].getType().getName() + ".class";
                values[i] = parameters[i].getName();
            }

            stbTemp.append("new java.lang.Class[] {");
            stbTemp.append(String.join(", ", types));
            stbTemp.append("}, ");
            stbTemp.append("new java.lang.Object[] {");
            stbTemp.append(String.join(", ", values));

            stbTemp.append("}");
        }
        else {
            stbTemp.append("null, null");
        }
        stbTemp.append(");\n");

        if(!method.getReturnType().getCanonicalName().equals("void")) {
            stbTemp.append("\t\t");
            stbTemp.append("return ");
            stbTemp.append("(").append(method.getReturnType().getCanonicalName()).append(") ");
            stbTemp.append("obj");
            stbTemp.append(";\n");
        }

        stbTemp.append("\t}\n");
    }

    private void generateEmptyLine() {
        stbTemp.append("\n");
    }

    private void generateLastLine() {
        stbTemp.append("}\n");
    }

    private void saveGeneratedClass() throws Exception {
        System.out.println(stbTemp.toString());
//        File file=new File(locationStub);
//        file.mkdirs();
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
