package eu.glowacki.jaxws.client.test;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.IServiceNew;
import eu.glowacki.jaxws.api.Person;
import jakarta.xml.ws.Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public final class MainProxyPeopleTest {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    private IServiceNew _proxy;

    @Before
    public void before() throws MalformedURLException {
        URL wsdl = new URL(IServiceNew.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu.jaxws.implementation", "PeopleSOAP");
        Service service = Service.create(wsdl, qname);
        _proxy = service.getPort(IServiceNew.class);
    }

    @Test
    public void testGetPersonBySurname() {
        List<Person> peopleWithSurname = _proxy.getPersonBySurname("Kilic");
        Assert.assertNotNull(peopleWithSurname);

        Assert.assertTrue("No people with surname Kilic found", peopleWithSurname.size() > 0);

        for (Person person : peopleWithSurname) {
            Assert.assertEquals("Kilic", person.getSurname());
            LOGGER.info("Person with surname Kilic: " + person);
        }
    }


    @Test
    public void testGetPersonByBirthDate() throws Exception {
        String testBirthDate = "2002-08-01";

        List<Person> peopleByBirthDate = _proxy.getPersonByBirthDate(testBirthDate);

        Assert.assertNotNull(peopleByBirthDate);

        Assert.assertTrue("No people with birth date " + testBirthDate + " found", peopleByBirthDate.size() > 0);

        for (Person person : peopleByBirthDate) {
            Assert.assertEquals(testBirthDate, person.getBirthDate().toString());
            LOGGER.info("Person with birth date " + testBirthDate + ": " + person);
        }
    }

}
