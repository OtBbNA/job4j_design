package ru.job4j.ood.examples;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShopLSP {

    private String name;
    protected int employeeAmount;
    protected Map<Integer, SectionLSP> section;

    public ShopLSP(String name, int employeeAmount, Map<Integer, SectionLSP> section) {
        this.name = name;
        this.employeeAmount = employeeAmount;
        this.section = section;
    }

    public Date open() {
        state();
        if (employeeAmount < section.size() * 5) {
            throw new IllegalArgumentException();
        }
        return new Date();
    }

    public void state() {
        if (name.isBlank() || employeeAmount <= 0 || section.size() <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeAmount(int employeeAmount) {
        this.employeeAmount = employeeAmount;
    }

    public void setSection(HashMap<Integer, SectionLSP> section) {
        this.section = section;
    }
}
