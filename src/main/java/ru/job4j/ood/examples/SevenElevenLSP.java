package ru.job4j.ood.examples;


import java.util.Date;
import java.util.Map;

public class SevenElevenLSP extends ShopLSP {

    public SevenElevenLSP(String name, int employeeAmount, Map<Integer, SectionLSP> section) {
        super(name, employeeAmount, section);
    }

    public Date open() {
        if (employeeAmount < 50) {
            throw new IllegalArgumentException();
        }
        Date date = new Date();
        date.setTime(47389579375L);
        return date;
    }
}
