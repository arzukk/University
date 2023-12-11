
package eu.glowacki;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.2
 * 2023-05-19T18:34:45.632+02:00
 * Generated source version: 3.5.2
 *
 */
public final class IEcho_BasicHttpBindingIEcho_Client {

    private static final QName SERVICE_NAME = new QName("http://glowacki.eu", "EchoImpl");

    private IEcho_BasicHttpBindingIEcho_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = EchoImpl.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        EchoImpl ss = new EchoImpl(wsdlURL, SERVICE_NAME);
        IEcho port = ss.getBasicHttpBindingIEcho();

        {
        System.out.println("Invoking echo...");
        org.datacontract.schemas._2004._07.glowacki_soap.EchoRequest _echo_request = null;
        org.datacontract.schemas._2004._07.glowacki_soap.EchoResponse _echo__return = port.echo(_echo_request);
        System.out.println("echo.result=" + _echo__return);


        }

        System.exit(0);
    }

}
