package ru.job4j.ood.lsp.parking.parkingspace;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.car.Car;
import ru.job4j.ood.lsp.parking.car.CarAuto;
import ru.job4j.ood.lsp.parking.car.CarGenerator;
import ru.job4j.ood.lsp.parking.car.CarTruck;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class ParkingSpaceGeneratorTest {

    @Test
    void whenGenerateThenListOfParkingSpace() {
        ParkingSpaceGenerator parkingGenerator = new ParkingSpaceGenerator();
        Random random = new Random();
        int amount = 100;
        List<ParkingSpace> parkingSpace = parkingGenerator.generate(random, amount);
        assertThat(parkingSpace.size()).isEqualTo(amount);
        for (ParkingSpace parking : parkingSpace) {
            if (parking.getSize() == 1) {
                assertThat(parking.getClass()).isEqualTo(ParkingSpaceAuto.class);
            } else {
                assertThat(parking.getClass()).isEqualTo(ParkingSpaceTruck.class);
            }
        }
    }
}