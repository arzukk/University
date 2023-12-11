package eu.glowacki.jaxws.implementation.composite;

import eu.glowacki.jaxws.api.composite.AddRequest;
import eu.glowacki.jaxws.api.composite.AddResponse;
import eu.glowacki.jaxws.api.composite.IComposite;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

import java.math.BigInteger;
import java.util.logging.Logger;

@WebService( //
		name = "IComposite", //
		targetNamespace = "http://glowacki.eu/composite" //
)
public final class CompositeImpl implements IComposite {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String... args) {
		Endpoint.publish(IComposite.URI, new CompositeImpl());
		LOGGER.info("SERVICE STARTED");
	}

	public AddResponse add(AddRequest request) {
		BigInteger result = request.constituent1.add(request.constituent2);
		AddResponse response = new AddResponse(result);
		LOGGER.info("response: " + response + "(result: " + response.result + ")");
		return response;
	}
}