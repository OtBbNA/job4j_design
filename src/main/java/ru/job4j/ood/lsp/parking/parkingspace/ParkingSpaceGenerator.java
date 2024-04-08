package ru.job4j.ood.lsp.parking.parkingspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingSpaceGenerator {

    public List<ParkingSpace> generate(Random random, int amount) {
        List<ParkingSpace> rsl = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int rand = random.nextInt(4);
            switch (rand) {
                case 2, 3 -> rsl.add(new ParkingSpaceTruck(String.valueOf(i)));
                default -> rsl.add(new ParkingSpaceAuto(String.valueOf(i)));
            }
        }
        return rsl;
    }
}
