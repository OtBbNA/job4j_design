package ru.job4j.ood.lsp.parking.car;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class CarGeneratorTest {

    @Test
    void whenGenerateThenListOfCar() {
        CarGenerator carGenerator = new CarGenerator();
        Random random = new Random();
        int amount = 100;
        List<Car> cars = carGenerator.generate(random, amount);
        assertThat(cars.size()).isEqualTo(amount);
        for (Car car : cars) {
            if (car.getSize() == 1) {
                assertThat(car.getClass()).isEqualTo(CarAuto.class);
            } else {
                assertThat(car.getClass()).isEqualTo(CarTruck.class);
            }
        }
    }
}