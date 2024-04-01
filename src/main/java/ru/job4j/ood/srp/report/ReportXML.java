package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private final Store store;
    private Marshaller marshaller;
    private JAXBContext context;

    public ReportXML(Store store) {
        this.store = store;
        try {
            context = JAXBContext.newInstance(MemoryStore.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        String text = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(store, writer);
            text = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
