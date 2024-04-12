package ru.job4j.ood.lsp.control;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.store.Shop;
import ru.job4j.ood.lsp.store.Store;
import ru.job4j.ood.lsp.store.Trash;
import ru.job4j.ood.lsp.store.Warehouse;
import ru.job4j.ood.lsp.food.Food;
import static org.assertj.core.api.Assertions.*;

import java.util.*;

class ControlQualityTest {

    @Test
    void whenCurrentDateMoreExpiryDateThenTrash() {
        List<Store> stores = List.of(new Trash(), new Shop(), new Warehouse());
        List<Food> foods = new ArrayList<>();
        Calendar currentDate = new GregorianCalendar(2024, Calendar.NOVEMBER, 1);
        Food milk = new Food("milk",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.OCTOBER, 1),
                324D,
                20);
        foods.add(milk);
        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.distribution(currentDate);
        assertThat(stores.get(0).get()).contains(milk);
        assertThat(stores.get(1).get()).isEmpty();
        assertThat(stores.get(2).get()).isEmpty();
    }

    @Test
    void whenCurrentDateIsCloseToCreateDateThenWarehouse() {
        List<Store> stores = List.of(new Trash(), new Shop(), new Warehouse());
        List<Food> foods = new ArrayList<>();
        Calendar currentDate = new GregorianCalendar(2024, Calendar.JANUARY, 7);
        Food milk = new Food("milk",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.OCTOBER, 1),
                324D,
                20);
        foods.add(milk);
        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.distribution(currentDate);
        assertThat(stores.get(2).get()).contains(milk);
        assertThat(stores.get(0).get()).isEmpty();
        assertThat(stores.get(1).get()).isEmpty();
    }

    @Test
    void whenCurrentDateIsHalfOfFreshnessThenShop() {
        List<Store> stores = List.of(new Trash(), new Shop(), new Warehouse());
        List<Food> foods = new ArrayList<>();
        Calendar currentDate = new GregorianCalendar(2024, Calendar.MAY, 7);
        Food milk = new Food("milk",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.OCTOBER, 1),
                324D,
                20);
        foods.add(milk);
        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.distribution(currentDate);
        assertThat(stores.get(1).get()).contains(milk);
        assertThat(stores.get(0).get()).isEmpty();
        assertThat(stores.get(2).get()).isEmpty();
    }

    @Test
    void whenCurrentDateIsCloseToExpiryDateThenShopWithDiscount() {
        List<Store> stores = List.of(new Trash(), new Shop(), new Warehouse());
        List<Food> foods = new ArrayList<>();
        Calendar currentDate = new GregorianCalendar(2024, Calendar.SEPTEMBER, 7);
        Food milk = new Food("milk",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.OCTOBER, 1),
                324D,
                20);
        foods.add(milk);
        double expectedPrice = milk.getPrice() * 0.8;
        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.distribution(currentDate);
        assertThat(stores.get(1).get().get(0).getPrice()).isEqualTo(expectedPrice);
        assertThat(stores.get(0).get()).isEmpty();
        assertThat(stores.get(2).get()).isEmpty();
    }

    @Test
    void whenManyProductThenAllStoresHaveProduct() {
        List<Store> stores = List.of(new Trash(), new Shop(), new Warehouse());
        Calendar currentDate = new GregorianCalendar(2024, Calendar.JUNE, 1);
        Food milk = new Food("milk",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.MAY, 1),
                256D,
                20);
        Food butter = new Food("butter",
                new GregorianCalendar(2024, Calendar.APRIL, 1),
                new GregorianCalendar(2024, Calendar.AUGUST, 1),
                167D,
                20);
        Food chips = new Food("chips",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.JUNE, 10),
                200D,
                20);
        Food bread = new Food("bread",
                new GregorianCalendar(2024, Calendar.MAY, 30),
                new GregorianCalendar(2024, Calendar.JUNE, 10),
                200D,
                20);
        List<Food> foods = List.of(milk, butter, chips, bread);
        double expectedPrice = chips.getPrice() * 0.8;
        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.distribution(currentDate);
        assertThat(stores.get(0).get()).contains(milk);
        assertThat(stores.get(1).get()).contains(butter);
        assertThat(stores.get(1).get().get(1).getPrice()).isEqualTo(expectedPrice);
        assertThat(stores.get(2).get()).contains(bread);
    }

    @Test
    void whenThereAreNoStoreThenFalse() {
        List<Store> stores = List.of();
        List<Food> foods = new ArrayList<>();
        Calendar currentDate = new GregorianCalendar(2024, Calendar.JANUARY, 7);
        Food milk = new Food("milk",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.OCTOBER, 1),
                324D,
                20);
        foods.add(milk);
        ControlQuality controlQuality = new ControlQuality(foods, stores);
        assertThat(controlQuality.distribution(currentDate)).isEqualTo(false);
        assertThat(stores).isEmpty();
    }

    @Test
    void whenAddAndResortForLaterDateThanAllAddedFoodsGoToTrash() {
        List<Store> stores = List.of(new Trash(), new Shop(), new Warehouse());
        Calendar currentDate = new GregorianCalendar(2024, Calendar.JUNE, 1);
        Food milk = new Food("milk",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.MAY, 1),
                256D,
                20);
        Food butter = new Food("butter",
                new GregorianCalendar(2024, Calendar.APRIL, 1),
                new GregorianCalendar(2024, Calendar.AUGUST, 1),
                167D,
                20);
        Food chips = new Food("chips",
                new GregorianCalendar(2024, Calendar.JANUARY, 1),
                new GregorianCalendar(2024, Calendar.JUNE, 10),
                200D,
                20);
        Food bread = new Food("bread",
                new GregorianCalendar(2024, Calendar.MAY, 30),
                new GregorianCalendar(2024, Calendar.JUNE, 10),
                200D,
                20);
        List<Food> foods = List.of(milk, butter, chips, bread);
        ControlQuality controlQuality = new ControlQuality(foods, stores);
        controlQuality.distribution(currentDate);
        currentDate = new GregorianCalendar(2024, Calendar.JULY, 1);
        controlQuality.resort(currentDate);
        assertThat(stores.get(0).getClass()).isEqualTo(Trash.class);
        assertThat(foods).containsAll(stores.get(0).get());
    }
}