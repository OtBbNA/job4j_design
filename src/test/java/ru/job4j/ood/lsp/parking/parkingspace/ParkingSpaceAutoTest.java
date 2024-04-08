package ru.job4j.ood.lsp.parking.parkingspace;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.car.CarAuto;

import static org.assertj.core.api.Assertions.*;

class ParkingSpaceAutoTest {

    @Test
    void whenCreateParkingSpaceAutoThenSize1() {
        ParkingSpaceAuto auto = new ParkingSpaceAuto("");
        assertThat(auto.getSize()).isEqualTo(1);
    }
}