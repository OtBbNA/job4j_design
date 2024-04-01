package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReportXMLTest {

    @Test
    void generate() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker0 = new Employee("Ruslan", now, now, 220);
        Employee worker1 = new Employee("Milan", now, now, 120);
        String date = new ReportDateTimeParser().parse(now);
        store.add(worker0);
        store.add(worker1);
        Report engine = new ReportXML(store);
        List<String> expected = List.of("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>",
                "<employees>",
                "<employee>",
                "<name>Ruslan</name>",
                "<hired>" + date + "</hired>",
                "<fired>" + date + "</fired>",
                "<salary>220.0</salary>",
                "</employee>",
                "<employee>",
                "<name>Milan</name>",
                "<hired>" + date + "</hired>",
                "<fired>" + date + "</fired>",
                "<salary>120.0</salary>",
                "</employee>",
                "</employees>");
        assertThat(engine.generate(employee -> true)).contains(expected);
    }
}