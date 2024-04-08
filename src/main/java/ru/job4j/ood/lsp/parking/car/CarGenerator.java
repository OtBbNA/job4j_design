package ru.job4j.ood.lsp.parking.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGenerator {

    public List<Car> generate(Random random, int amount) {
        List<Car> rsl = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int rand = random.nextInt(4);
            switch (rand) {
                case 2, 3 -> rsl.add(new CarTruck());
                default -> rsl.add(new CarAuto());
            }
        }
        return rsl;
    }
}
