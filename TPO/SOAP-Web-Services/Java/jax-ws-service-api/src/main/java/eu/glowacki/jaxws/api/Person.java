package eu.glowacki.jaxws.api;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement
public class Person {
    private String firstName;
    private String surname;
    private LocalDate birthDate;

    public Person(){

    }

    public Person(String firstName, String surname, LocalDate birthDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public String getSurname() {
        return surname;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + getFirstName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}
