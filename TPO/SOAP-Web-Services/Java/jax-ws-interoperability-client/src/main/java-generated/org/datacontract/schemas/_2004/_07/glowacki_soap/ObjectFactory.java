
package org.datacontract.schemas._2004._07.glowacki_soap;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.glowacki_soap package. 
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

    private final static QName _EchoRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API", "EchoRequest");
    private final static QName _EchoResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API", "EchoResponse");
    private final static QName _EchoResponseContent_QNAME = new QName("http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API", "Content");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.glowacki_soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EchoRequest }
     * 
     */
    public EchoRequest createEchoRequest() {
        return new EchoRequest();
    }

    /**
     * Create an instance of {@link EchoResponse }
     * 
     */
    public EchoResponse createEchoResponse() {
        return new EchoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EchoRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EchoRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API", name = "EchoRequest")
    public JAXBElement<EchoRequest> createEchoRequest(EchoRequest value) {
        return new JAXBElement<EchoRequest>(_EchoRequest_QNAME, EchoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EchoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EchoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API", name = "EchoResponse")
    public JAXBElement<EchoResponse> createEchoResponse(EchoResponse value) {
        return new JAXBElement<EchoResponse>(_EchoResponse_QNAME, EchoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API", name = "Content", scope = EchoResponse.class)
    public JAXBElement<String> createEchoResponseContent(String value) {
        return new JAXBElement<String>(_EchoResponseContent_QNAME, String.class, EchoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API", name = "Content", scope = EchoRequest.class)
    public JAXBElement<String> createEchoRequestContent(String value) {
        return new JAXBElement<String>(_EchoResponseContent_QNAME, String.class, EchoRequest.class, value);
    }

}
