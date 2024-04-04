package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.food.Food;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    @Test
    void whenAddPercentLessThen25ThenAdd() {
        Warehouse warehouse = new Warehouse();
        Food milk = new Food();
        double percent = 24;
        warehouse.add(milk, percent);
        assertThat(warehouse.get()).contains(milk);
    }

    @Test
    void whenAddPercentMoreThen25ThenContainerIsEmpty() {
        Warehouse warehouse = new Warehouse();
        Food milk = new Food();
        double percent = 90;
        warehouse.add(milk, percent);
        assertThat(warehouse.get()).isEmpty();
    }
}