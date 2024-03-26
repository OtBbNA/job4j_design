package ru.job4j.ood.srp.model;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() >= o2.getSalary() ? -1 : 1;
    }
}
