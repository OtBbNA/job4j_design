package ru.job4j.ood.srp.examples;

import java.util.Date;
import java.util.Map;

public class SevenElevenSanAntonioLSP extends SevenElevenLSP {

    public SevenElevenSanAntonioLSP(String name, int employeeAmount, Map<Integer, SectionLSP> section) {
        super(name, employeeAmount, section);
    }

    public Date open() {
        if (employeeAmount < 100) {
            throw new IllegalArgumentException();
        }
        setEmployeeAmount(-100);
        return new Date();
    }
}
