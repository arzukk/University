package eu.glowacki.jaxws.client.delayed;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.ClientException;
import eu.glowacki.jaxws.client.delayed.proxy.AddResponse;
import eu.glowacki.jaxws.client.delayed.proxy.ICalculatorDelayed;
import eu.glowacki.jaxws.client.delayed.proxy.ServiceException_Exception;
import jakarta.xml.ws.Response;
import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public final class MainAsyncPollingNoProxy {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private static final int POLL_INTERVAL = 1000;

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    public static void main(String... args) throws MalformedURLException, ServiceException_Exception,
            ExecutionException, InterruptedException, ClientException {

        URL wsdl = new URL(eu.glowacki.jaxws.api.delayed.ICalculatorDelayed.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu/delayed", "CalculatorDelayedImplService");
        Service service = Service.create(wsdl, qname);
        ICalculatorDelayed proxy = service.getPort(ICalculatorDelayed.class);
        Response<AddResponse> response = proxy.addAsync(3, 1);
        while (!response.isDone()) {
            LOGGER.info("waiting...");
            sleep();
        }
        LOGGER.info("sum: " + response.get().getReturn());
    }

    private static void sleep() throws ClientException {
        try {
            Thread.sleep(POLL_INTERVAL);
        } catch (InterruptedException exception) {
            throw new ClientException("error occurred", exception);
        }
    }
}