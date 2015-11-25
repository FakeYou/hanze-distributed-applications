/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hanze.distrans.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;
import nl.hanze.distrans.sessionbean.DisTransSBLocal;

/**
 *
 * @author zech
 */
@WebService(serviceName = "DisTransWS")
@Stateless()
public class DisTransWS {
    @EJB
    private DisTransSBLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "from1To2")
    public boolean from1To2(@WebParam(name = "amount") int amount) {
        return ejbRef.from1To2(amount);
    }
    
}
