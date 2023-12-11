package eu.glowacki.jaxws.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, formatter);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(formatter);
    }

    public static String marshall(LocalDate v) {
        return v.format(formatter);
    }

    public static LocalDate unmarshall(String v) throws Exception {
        return LocalDate.parse(v, formatter);
    }
}

