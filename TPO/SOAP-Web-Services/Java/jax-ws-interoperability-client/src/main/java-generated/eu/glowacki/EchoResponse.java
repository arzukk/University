
package eu.glowacki;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EchoResult" type="{http://schemas.datacontract.org/2004/07/Glowacki.SOAP.API}EchoResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "echoResult"
})
@XmlRootElement(name = "EchoResponse")
public class EchoResponse {

    @XmlElementRef(name = "EchoResult", namespace = "http://glowacki.eu", type = JAXBElement.class, required = false)
    protected JAXBElement<org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse> echoResult;

    /**
     * Gets the value of the echoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse }{@code >}
     *     
     */
    public JAXBElement<org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse> getEchoResult() {
        return echoResult;
    }

    /**
     * Sets the value of the echoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse }{@code >}
     *     
     */
    public void setEchoResult(JAXBElement<org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse> value) {
        this.echoResult = value;
    }

}
