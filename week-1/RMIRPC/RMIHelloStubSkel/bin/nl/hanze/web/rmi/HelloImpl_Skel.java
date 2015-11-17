// Skeleton class generated by rmic, do not edit.
// Contents subject to change without notice.

package nl.hanze.web.rmi;

public final class HelloImpl_Skel
    implements java.rmi.server.Skeleton
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("int ageNextYear(int)"),
	new java.rmi.server.Operation("java.lang.String sayHello()"),
	new java.rmi.server.Operation("java.lang.String sayHello(int)"),
	new java.rmi.server.Operation("java.lang.String sayHello(java.lang.String)"),
	new java.rmi.server.Operation("java.lang.String sayHello(java.lang.String, int)")
    };
    
    private static final long interfaceHash = -2303055944006232026L;
    
    public java.rmi.server.Operation[] getOperations() {
	return (java.rmi.server.Operation[]) operations.clone();
    }
    
    public void dispatch(java.rmi.Remote obj, java.rmi.server.RemoteCall call, int opnum, long hash)
	throws java.lang.Exception
    {
	if (hash != interfaceHash)
	    throw new java.rmi.server.SkeletonMismatchException("interface hash mismatch");
	
	nl.hanze.web.rmi.HelloImpl server = (nl.hanze.web.rmi.HelloImpl) obj;
	switch (opnum) {
	case 0: // ageNextYear(int)
	{
	    int $param_int_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_int_1 = in.readInt();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    int $result = server.ageNextYear($param_int_1);
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeInt($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 1: // sayHello()
	{
	    call.releaseInputStream();
	    java.lang.String $result = server.sayHello();
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 2: // sayHello(int)
	{
	    int $param_int_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_int_1 = in.readInt();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    java.lang.String $result = server.sayHello($param_int_1);
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 3: // sayHello(String)
	{
	    java.lang.String $param_String_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_String_1 = (java.lang.String) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    java.lang.String $result = server.sayHello($param_String_1);
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 4: // sayHello(String, int)
	{
	    java.lang.String $param_String_1;
	    int $param_int_2;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_String_1 = (java.lang.String) in.readObject();
		$param_int_2 = in.readInt();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    java.lang.String $result = server.sayHello($param_String_1, $param_int_2);
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	default:
	    throw new java.rmi.UnmarshalException("invalid method number");
	}
    }
}