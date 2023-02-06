package ru.job4j.serialization.json;

import java.util.Arrays;
import java.util.List;

public class JsonMyExample {
    private boolean magazine;
    private int numberOfRounds;
    private String firingMode;
    private Cartridges cartridges;
    private Cartridges[] rsl;
    private List<String> barrelFeatures;


    public JsonMyExample(boolean magazine, int numberOfRounds,
                         String firingMode, Cartridges cartridges, List<String> barrelFeatures) {
        this.magazine = magazine;
        this.numberOfRounds = numberOfRounds;
        this.firingMode = firingMode;
        this.cartridges = cartridges;
        this.rsl = new Cartridges[numberOfRounds];
        Arrays.fill(rsl, cartridges);
        this.barrelFeatures = barrelFeatures;
    }


    @Override
    public String toString() {
        return "JsonMyExample{"
                + "magazine=" + magazine
                + ", numberOfRounds=" + numberOfRounds
                + ", firingMode='" + firingMode + '\''
                + ", cartridges=" + cartridges
                + ", rsl=" + Arrays.toString(rsl)
                + '}';
    }
}
