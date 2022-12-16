package ru.job4j.serialization.json;

import java.util.Arrays;

public class JsonMyExample {
    private boolean magazine;
    private int numberOfRounds;
    private String firingMode;
    private Cartridges cartridges;
    private Cartridges[] rsl;


    public JsonMyExample(boolean magazine, int numberOfRounds,
                         String firingMode, Cartridges cartridges) {
        this.magazine = magazine;
        this.numberOfRounds = numberOfRounds;
        this.firingMode = firingMode;
        this.cartridges = cartridges;
        this.rsl = new Cartridges[numberOfRounds];
        Arrays.fill(rsl, cartridges);
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
