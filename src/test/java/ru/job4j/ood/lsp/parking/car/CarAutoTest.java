package ru.job4j.ood.lsp.parking.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarAutoTest {

    @Test
    void whenCreateCarAutomobileThenSize1() {
        CarAuto auto = new CarAuto();
        assertThat(auto.getSize()).isEqualTo(1);
    }
}