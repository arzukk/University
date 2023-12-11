package eu.glowacki.interoperability.client;

import eu.glowacki.EchoImpl;
import org.datacontract.schemas._2004._07.glowacki_soap.EchoRequest;
import org.datacontract.schemas._2004._07.glowacki_soap.ObjectFactory;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

public final class EchoImplTest {

    private static final String URL_SPEC = "http://localhost:20000/?singleWsdl";


    private EchoImpl _sut;

    @Before
    public void before() throws Throwable {
        var url = new URL(URL_SPEC);
        _sut = new EchoImpl(url);
    }

    @Test
    public void echo() {
        final String content = "content";
        var proxy = _sut.getBasicHttpBindingIEcho();
        var request = request(content);
    }

    private static EchoRequest request(String content) {
        var factory = new ObjectFactory();
        var element = factory.createEchoRequestContent(content);
        var request = factory.createEchoRequest();
        request.setContent(element);
        return request;
    }
}
