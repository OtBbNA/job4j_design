package ru.job4j.ood.srp.report;

import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReportJSONTest {

    @Test
    void generate() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker0 = new Employee("Ruslan", now, now, 220);
        Employee worker1 = new Employee("Milan", now, now, 120);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        GsonBuilder gson = new GsonBuilder();
        String date = parser.parse(now);
        store.add(worker0);
        store.add(worker1);
        Report engine = new ReportJSON(store, parser, gson);
        List<String> expected = List.of("[", "{",
                "\"name\": \"Ruslan\",",
                "\"hired\": \"" + date + "\",",
                "\"fired\": \"" + date + "\",",
                "\"salary\": \"220.0\"",
                "}", "{",
                "\"name\": \"Milan\",",
                "\"hired\": \"" + date + "\",",
                "\"fired\": \"" + date + "\",",
                "\"salary\": \"120.0\"",
                "}", "]");
        assertThat(engine.generate(employee -> true)).contains(expected);
    }
}