package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.food.Food;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    @Test
    void whenAddPercentLessThen25ThenContainerIsEmpty() {
        Shop shop = new Shop();
        Food milk = new Food();
        double percent = 20;
        shop.add(milk, percent);
        assertThat(shop.get()).isEmpty();
    }

    @Test
    void whenAddPercentMoreThen99ThenContainerIsEmpty() {
        Shop shop = new Shop();
        Food milk = new Food();
        double percent = 100;
        shop.add(milk, percent);
        assertThat(shop.get()).isEmpty();
    }

    @Test
    void whenAddPercentMoreThen25AndLessThen75ThenContainerIsContainsAddedWithoutDiscount() {
        Shop shop = new Shop();
        Food milk = new Food();
        milk.setPrice(100);
        milk.setDiscount(20);
        double percent = 50;
        shop.add(milk, percent);
        assertThat(shop.get()).contains(milk);
        assertThat(shop.get().get(0).getPrice()).isEqualTo(milk.getPrice());
    }

    @Test
    void whenAddPercentMoreThen75AndLessThen100ThenContainerIsContainsAddedWithDiscount() {
        Shop shop = new Shop();
        Food milk = new Food();
        milk.setPrice(100);
        milk.setDiscount(20);
        double percent = 90;
        double expectedPrice = 80;
        shop.add(milk, percent);
        assertThat(shop.get()).contains(milk);
        assertThat(shop.get().get(0).getPrice()).isEqualTo(expectedPrice);
    }
}