
package eu.glowacki.jaxws.client.sample.proxy;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ICalculator", targetNamespace = "http://glowacki.eu/sample")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ICalculator {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://glowacki.eu/sample", className = "eu.glowacki.jaxws.client.sample.proxy.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://glowacki.eu/sample", className = "eu.glowacki.jaxws.client.sample.proxy.AddResponse")
    @Action(input = "http://glowacki.eu/sample/ICalculator/addRequest", output = "http://glowacki.eu/sample/ICalculator/addResponse")
    public int add(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "subtract", targetNamespace = "http://glowacki.eu/sample", className = "eu.glowacki.jaxws.client.sample.proxy.Subtract")
    @ResponseWrapper(localName = "subtractResponse", targetNamespace = "http://glowacki.eu/sample", className = "eu.glowacki.jaxws.client.sample.proxy.SubtractResponse")
    @Action(input = "http://glowacki.eu/sample/ICalculator/subtractRequest", output = "http://glowacki.eu/sample/ICalculator/subtractResponse")
    public int subtract(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
