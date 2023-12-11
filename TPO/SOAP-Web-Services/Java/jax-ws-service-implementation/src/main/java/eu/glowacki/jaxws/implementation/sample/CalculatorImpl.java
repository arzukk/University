package eu.glowacki.jaxws.implementation.sample;

import eu.glowacki.jaxws.api.sample.ICalculator;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

import java.util.logging.Logger;

@WebService( //
		name = "ICalculator", //
		targetNamespace = "http://glowacki.eu/sample",
		serviceName = "ArzuW"//
)
public final class CalculatorImpl implements ICalculator {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String... args) {
		Endpoint.publish(ICalculator.URI, new CalculatorImpl());
		LOGGER.info("SERVICE STARTED");
	}

	public int add(int component1, int component2) {
		int sum = component1 + component2;
		LOGGER.info("sum: " + sum);
		return sum;
	}

	public int subtract(int minuend, int subtrahend) {
		int difference =  minuend - subtrahend;
		LOGGER.info("difference: " + difference);
		return difference;
	}
}