package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportProgrammersTest {

    @Test
    public void whenOldGenerated(@TempDir Path tempDir) throws JAXBException {
        Path path = tempDir.resolve("report.csv");
        String delimiter = ";";
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportProgrammers(store, parser, delimiter, path);
        StringBuilder expected = new StringBuilder()
                .append("Name;Hired;Fired;Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(delimiter)
                .append(parser.parse(worker.getHired())).append(delimiter)
                .append(parser.parse(worker.getFired())).append(delimiter)
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}