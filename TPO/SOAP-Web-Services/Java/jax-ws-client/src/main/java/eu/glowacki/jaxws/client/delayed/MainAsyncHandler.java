package eu.glowacki.jaxws.client.delayed;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.ClientException;
import eu.glowacki.jaxws.client.delayed.proxy.AddResponse;
import eu.glowacki.jaxws.client.delayed.proxy.CalculatorDelayedImplService;
import eu.glowacki.jaxws.client.delayed.proxy.ICalculatorDelayed;
import eu.glowacki.jaxws.client.delayed.proxy.ServiceException_Exception;
import jakarta.xml.ws.AsyncHandler;
import jakarta.xml.ws.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public final class MainAsyncHandler {

	private static final Logger LOGGER = Logger.getAnonymousLogger();
	private static final int POLL_INTERVAL = 1000;

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "99999999");
	}

	public static void main(String... args) throws MalformedURLException, ServiceException_Exception,
			ExecutionException, InterruptedException, ClientException {

		//
		//
		URL wsdl = new URL(eu.glowacki.jaxws.api.delayed.ICalculatorDelayed.URI + IService.WSDL_SUFFIX);
		CalculatorDelayedImplService service = new CalculatorDelayedImplService(wsdl);
		ICalculatorDelayed proxy = service.getICalculatorDelayedPort();
		Handler handler = new Handler();
		proxy.addAsync(3, 1, handler);
		while (!handler._accomplished) {
			LOGGER.info("waiting...");
			sleep();
		}
		LOGGER.info("accomplished: " + handler._accomplished + ", sum: " + handler._response.getReturn());
	}

	private static void sleep() throws ClientException {
		try {
			Thread.sleep(POLL_INTERVAL);
		} catch (InterruptedException exception) {
			throw new ClientException("error occurred", exception);
		}
	}

	private static final class Handler implements AsyncHandler<AddResponse> {

		private AddResponse _response;
		private volatile boolean _accomplished;

		@Override
		public void handleResponse(Response<AddResponse> response) {
			try {
				_response = response.get();
				_accomplished = true;
			} catch (ExecutionException | InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}
}