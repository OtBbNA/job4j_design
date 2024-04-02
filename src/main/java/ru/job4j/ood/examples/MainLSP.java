package ru.job4j.ood.examples;

import java.util.HashMap;
import java.util.Map;

public class MainLSP {

    public static void main(String[] args) {
        Map<Integer, SectionLSP> section = new HashMap<>();
        section.put(0, new SectionLSP("Fish"));
        section.put(1, new SectionLSP("Fresh"));
        section.put(2, new SectionLSP("Tea"));
        SevenElevenSanAntonioLSP seSA = new SevenElevenSanAntonioLSP("Seven Eleven", 100, section);
        seSA.open();
        SevenElevenLSP se = new SevenElevenLSP("Seven Eleven", 100, section);
        se.open();
    }
}
