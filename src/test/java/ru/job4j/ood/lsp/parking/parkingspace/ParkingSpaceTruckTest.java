package ru.job4j.ood.lsp.parking.parkingspace;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.car.CarTruck;

import static org.assertj.core.api.Assertions.*;

class ParkingSpaceTruckTest {

    @Test
    void whenCreateParkingSpaceTruckThenSize1() {
        for (int i = 0; i < 100; i++) {
            ParkingSpaceTruck truck = new ParkingSpaceTruck("");
            assertThat(truck.getSize()).isLessThan(9).isGreaterThan(1);
        }
    }
}