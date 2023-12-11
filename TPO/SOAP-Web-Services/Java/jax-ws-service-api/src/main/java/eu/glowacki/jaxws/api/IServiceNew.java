package eu.glowacki.jaxws.api;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import java.util.List;

@WebService(name = "IServiceNew", targetNamespace = "http://glowacki.eu.jaxws.implementation")
public interface IServiceNew {

    public static String URI ="http://localhost:8080/Task10";

    @WebMethod(action = "http://glowacki.eu.jaxws.implementation/getPersonBySurname")
    @WebResult(name = "getPersonBySurnameResponse")
    List<Person> getPersonBySurname(@WebParam(name = "surname") String surname);

    @WebMethod(action = "http://glowacki.eu.jaxws.implementation/getPersonByBirthDate")
    @WebResult(name = "getPersonByBirthDateResponse")
    List<Person> getPersonByBirthDate(@WebParam(name = "birthDate") String birthDate) throws Exception;
}
