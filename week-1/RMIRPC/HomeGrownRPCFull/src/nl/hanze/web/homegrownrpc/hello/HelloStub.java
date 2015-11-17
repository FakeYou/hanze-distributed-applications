package nl.hanze.web.homegrownrpc.hello;

public class HelloStub extends nl.hanze.web.homegrownrpc.generic.Stub implements nl.hanze.web.homegrownrpc.hello.Hello {
    public java.lang.String sayHello() throws java.lang.Exception {
        java.lang.Object o=invokeSkel("sayHello", null, null);
        return (java.lang.String) o;
    }

    public java.lang.String sayHello(java.lang.String p1) throws java.lang.Exception {
        java.lang.Object o=invokeSkel("sayHello", new java.lang.Class[] {java.lang.String.class}, new java.lang.Object[] {p1});
        return (java.lang.String) o;
    }

    public java.lang.String sayHello(int p1) throws java.lang.Exception {
        java.lang.Object o=invokeSkel("sayHello", new java.lang.Class[] {int.class}, new java.lang.Object[] {p1});
        return (java.lang.String) o;
    }

    public java.lang.String sayHello(java.lang.String p1, int p2) throws java.lang.Exception {
        java.lang.Object o=invokeSkel("sayHello", new java.lang.Class[] {java.lang.String.class, int.class}, new java.lang.Object[] {p1, p2});
        return (java.lang.String) o;
    }

    public int ageNextYear(int p1) throws java.lang.Exception {
        java.lang.Object o=invokeSkel("ageNextYear", new java.lang.Class[] {int.class}, new java.lang.Object[] {p1});
        return ((java.lang.Integer) o).intValue();
    }
}
