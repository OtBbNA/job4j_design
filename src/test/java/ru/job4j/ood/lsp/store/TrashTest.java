package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.food.Food;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    void whenAddPercentMoreThen100ThenAdd() {
        Trash trash = new Trash();
        Food milk = new Food();
        double percent = 110;
        trash.add(milk, percent);
        assertThat(trash.get()).contains(milk);
    }

    @Test
    void whenAddPercentLessThen100ThenContainerIsEmpty() {
        Trash trash = new Trash();
        Food milk = new Food();
        double percent = 90;
        trash.add(milk, percent);
        assertThat(trash.get()).isEmpty();
    }
}