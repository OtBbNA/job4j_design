package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportProgrammers implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final String delimiter;
    private final Path out;

    public ReportProgrammers(Store store, DateTimeParser<Calendar> dateTimeParser, String delimiter, Path out) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.delimiter = delimiter;
        this.out = out;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name").append(delimiter)
                .append("Hired").append(delimiter)
                .append("Fired").append(delimiter)
                .append("Salary").append(delimiter).append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(delimiter)
                    .append(dateTimeParser.parse(employee.getHired())).append(delimiter)
                    .append(dateTimeParser.parse(employee.getFired())).append(delimiter)
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        try (PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(out.toString())))) {
            output.append(text);
        } catch (IOException e) {
            e.getMessage();
        }
        return text.toString();
    }
}
