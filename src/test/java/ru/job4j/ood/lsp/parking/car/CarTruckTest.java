package ru.job4j.ood.lsp.parking.car;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.car.CarTruck;

import static org.assertj.core.api.Assertions.*;

class CarTruckTest {

    @Test
    void whenCreateCarTruckThenSize1() {
        for (int i = 0; i < 100; i++) {
            CarTruck truck = new CarTruck();
            assertThat(truck.getSize()).isLessThan(9).isGreaterThan(1);
        }
    }
}