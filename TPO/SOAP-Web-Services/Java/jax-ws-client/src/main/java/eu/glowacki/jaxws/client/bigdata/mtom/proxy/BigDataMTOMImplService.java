
package eu.glowacki.jaxws.client.bigdata.mtom.proxy;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BigDataMTOMImplService", targetNamespace = "http://glowacki.eu/big-data/mtom", wsdlLocation = "http://localhost:8080/big-data/mtom?wsdl")
public class BigDataMTOMImplService
    extends Service
{

    private final static URL BIGDATAMTOMIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException BIGDATAMTOMIMPLSERVICE_EXCEPTION;
    private final static QName BIGDATAMTOMIMPLSERVICE_QNAME = new QName("http://glowacki.eu/big-data/mtom", "BigDataMTOMImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/big-data/mtom?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BIGDATAMTOMIMPLSERVICE_WSDL_LOCATION = url;
        BIGDATAMTOMIMPLSERVICE_EXCEPTION = e;
    }

    public BigDataMTOMImplService() {
        super(__getWsdlLocation(), BIGDATAMTOMIMPLSERVICE_QNAME);
    }

    public BigDataMTOMImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BIGDATAMTOMIMPLSERVICE_QNAME, features);
    }

    public BigDataMTOMImplService(URL wsdlLocation) {
        super(wsdlLocation, BIGDATAMTOMIMPLSERVICE_QNAME);
    }

    public BigDataMTOMImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BIGDATAMTOMIMPLSERVICE_QNAME, features);
    }

    public BigDataMTOMImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BigDataMTOMImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IBigDataMTOM
     */
    @WebEndpoint(name = "IBigDataMTOMPort")
    public IBigDataMTOM getIBigDataMTOMPort() {
        return super.getPort(new QName("http://glowacki.eu/big-data/mtom", "IBigDataMTOMPort"), IBigDataMTOM.class);
    }

    /**
     * 
     * @param features
     *     A list of {&#064;link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the &lt;code&gt;features&lt;/code&gt; parameter will have their default values.
     * @return
     *     returns IBigDataMTOM
     */
    @WebEndpoint(name = "IBigDataMTOMPort")
    public IBigDataMTOM getIBigDataMTOMPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://glowacki.eu/big-data/mtom", "IBigDataMTOMPort"), IBigDataMTOM.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BIGDATAMTOMIMPLSERVICE_EXCEPTION!= null) {
            throw BIGDATAMTOMIMPLSERVICE_EXCEPTION;
        }
        return BIGDATAMTOMIMPLSERVICE_WSDL_LOCATION;
    }

}
