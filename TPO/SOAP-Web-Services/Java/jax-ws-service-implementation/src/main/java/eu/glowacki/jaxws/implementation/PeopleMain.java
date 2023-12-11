package eu.glowacki.jaxws.implementation;

import eu.glowacki.jaxws.api.IServiceNew;
import eu.glowacki.jaxws.api.LocalDateAdapter;
import eu.glowacki.jaxws.api.Person;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebService(
        name = "IServiceNew",
        targetNamespace = "http://glowacki.eu.jaxws.implementation",
        serviceName = "PeopleSOAP"
)
public final class PeopleMain implements IServiceNew {

    private static Map<String, Person> people = new HashMap<>();
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        people.put("person1", new Person("Arzu", "Kilic", LocalDate.of(2002, 8, 1)));
        people.put("person2", new Person("Azad", "Kilic", LocalDate.of(2004, 9, 6)));
        people.put("person3", new Person("Elon", "Musk", LocalDate.of(1990, 5, 12)));
        people.put("person4", new Person("Mark", "Offerman", LocalDate.of(2002, 8, 1)));
    }

    public static void main(String... args) {
        Endpoint.publish(IServiceNew.URI, new PeopleMain());
        LOGGER.info("SERVICE STARTED");
    }

    @Override
    @WebMethod(action = "http://glowacki.eu.jaxws.implementation/getPersonBySurname")
    @WebResult(name = "getPersonBySurnameResponse")
    public List<Person> getPersonBySurname(@WebParam(name = "surname") String surname) {
        List<Person> matchingPeople = new ArrayList<>();
        for (Person person : people.values()) {
            if (person.getSurname().equals(surname)) {
                matchingPeople.add(person);
            }
        }
        LOGGER.info("People with this surname: " + matchingPeople);
        return matchingPeople;
    }


    @Override
    @WebMethod(action = "http://glowacki.eu.jaxws.implementation/getPersonByBirthDate")
    @WebResult(name = "getPersonByBirthDateResponse")
    public List<Person> getPersonByBirthDate(@WebParam(name = "birthDate") String birthDate) throws Exception {
        List<Person> matchingPeople = new ArrayList<>();
        try {
            LocalDate searchDate = LocalDateAdapter.unmarshall(birthDate);
            for (Person person : people.values()) {
                if (person.getBirthDate() != null && person.getBirthDate().equals(searchDate)) {
                    matchingPeople.add(person);
                }
            }
        } catch (Exception e) {
            throw new Exception("Error while processing birth date", e);
        }
        LOGGER.info("People with this birthdate: " + matchingPeople);
        return matchingPeople;
    }

}
