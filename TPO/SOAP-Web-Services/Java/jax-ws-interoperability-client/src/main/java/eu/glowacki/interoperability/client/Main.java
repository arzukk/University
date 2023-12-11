package eu.glowacki.interoperability.client;

import eu.glowacki.EchoImpl;
import org.datacontract.schemas._2004._07.glowacki_soap.EchoRequest;
import org.datacontract.schemas._2004._07.glowacki_soap.ObjectFactory;

import java.net.URL;

public final class Main {

    private static final String URL_SPEC = "http://localhost:20000/?singleWsdl";

    public static void main(String... args) throws Throwable {
        var URL = new URL(URL_SPEC);
        var proxy = new EchoImpl(URL);
        var echo = proxy.getBasicHttpBindingIEcho();
        var request = request("message");
        var response = echo.echo(request);
        System.out.printf("response: '%s'", response.getContent().getValue());
    }

    private static EchoRequest request(String content) {
        var factory = new ObjectFactory();
        var element = factory.createEchoRequestContent(content);
        var request = factory.createEchoRequest();
        request.setContent(element);
        return request;
    }
}
