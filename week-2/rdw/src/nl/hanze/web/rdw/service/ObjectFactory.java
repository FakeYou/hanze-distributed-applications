//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.09 at 01:54:41 PM CET 
//


package nl.hanze.web.rdw.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.hanze.web.rdw.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetInfo_QNAME = new QName("http://service.rdw.web.hanze.nl/", "GetInfo");
    private final static QName _GetInfoResponse_QNAME = new QName("http://service.rdw.web.hanze.nl/", "GetInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.hanze.web.rdw.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfoResponse }
     * 
     */
    public GetInfoResponse createGetInfoResponse() {
        return new GetInfoResponse();
    }

    /**
     * Create an instance of {@link Kenteken }
     * 
     */
    public Kenteken createKenteken() {
        return new Kenteken();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Kenteken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.rdw.web.hanze.nl/", name = "GetInfo")
    public JAXBElement<Kenteken> createGetInfo(Kenteken value) {
        return new JAXBElement<Kenteken>(_GetInfo_QNAME, Kenteken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.rdw.web.hanze.nl/", name = "GetInfoResponse")
    public JAXBElement<GetInfoResponse> createGetInfoResponse(GetInfoResponse value) {
        return new JAXBElement<GetInfoResponse>(_GetInfoResponse_QNAME, GetInfoResponse.class, null, value);
    }

}
