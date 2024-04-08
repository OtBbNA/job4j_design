package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.car.Car;
import ru.job4j.ood.lsp.parking.car.CarGenerator;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpace;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpaceGenerator;

import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class ParkingAttendantTest {

    @Disabled
    @Test
    void whenParkingThen() {
        CarGenerator carGenerator = new CarGenerator();
        ParkingSpaceGenerator parkingSpaceGenerator = new ParkingSpaceGenerator();
        Random random = new Random();
        int amount = 20;
        ParkingAttendant parkingAttendant = new ParkingAttendant(
                carGenerator.generate(random, amount),
                parkingSpaceGenerator.generate(random, amount));
        Map<Car, ParkingSpace> parking = parkingAttendant.parking();
    }
}