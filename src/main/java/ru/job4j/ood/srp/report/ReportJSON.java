package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Gson gson;

    public ReportJSON(Store store, DateTimeParser<Calendar> dateTimeParser, GsonBuilder gson) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = gson.setPrettyPrinting().create();
    }

    @Override
        public String generate(Predicate<Employee> filter) {
        List<Employee.EmployeeFieldToString> serializedEmployees = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
           Employee.EmployeeFieldToString ef = new Employee.EmployeeFieldToString(employee.getName(),
                    dateTimeParser.parse(employee.getHired()),
                    dateTimeParser.parse(employee.getFired()),
                    String.valueOf(employee.getSalary()));
            serializedEmployees.add(ef);
        }
        return gson.toJson(serializedEmployees);
    }
}
