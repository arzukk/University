
package eu.glowacki;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.glowacki_soap.EchoRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.glowacki package. 
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

    private final static QName _EchoRequest_QNAME = new QName("http://glowacki.eu", "request");
    private final static QName _EchoResponseEchoResult_QNAME = new QName("http://glowacki.eu", "EchoResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.glowacki
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Echo }
     * 
     */
    public Echo createEcho() {
        return new Echo();
    }

    /**
     * Create an instance of {@link eu.glowacki.EchoResponse }
     * 
     */
    public eu.glowacki.EchoResponse createEchoResponse() {
        return new eu.glowacki.EchoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EchoRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EchoRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu", name = "request", scope = Echo.class)
    public JAXBElement<EchoRequest> createEchoRequest(EchoRequest value) {
        return new JAXBElement<EchoRequest>(_EchoRequest_QNAME, EchoRequest.class, Echo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu", name = "EchoResult", scope = eu.glowacki.EchoResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse> createEchoResponseEchoResult(org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse>(_EchoResponseEchoResult_QNAME, org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse.class, eu.glowacki.EchoResponse.class, value);
    }

}
