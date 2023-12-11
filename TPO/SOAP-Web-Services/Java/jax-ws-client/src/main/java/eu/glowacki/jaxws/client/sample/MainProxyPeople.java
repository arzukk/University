package eu.glowacki.jaxws.client.sample;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.IServiceNew;
import eu.glowacki.jaxws.api.Person;
import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public final class MainProxyPeople {

    private static final Logger LOGGER = Logger.getLogger(MainProxyPeople.class.getName());

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    public static void main(String... args) throws Exception {
        URL wsdl = new URL(IServiceNew.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu.jaxws.implementation", "PeopleSOAP");
        Service service = Service.create(wsdl, qname);
        IServiceNew proxy = service.getPort(IServiceNew.class);

        List<Person> peopleWithSurname = proxy.getPersonBySurname("Kilic");
        for (Person person : peopleWithSurname) {
            LOGGER.info("People with surname Kilic: " + person.getSurname() + ": " + person);
        }


        List<Person> peopleByBirthDate = proxy.getPersonByBirthDate("2002-08-01");
        for (Person person : peopleByBirthDate) {
            LOGGER.info("Person with birth date " + person.getBirthDate() + ": " + person);
        }

    }
}
