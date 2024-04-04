package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.food.Food;

public class Shop extends AbstractStore {

    @Override
    public void add(Food food, double percent) {
        if (percent > 25 && percent < 75) {
            container.add(food);
        } else if (percent >= 75 && percent < 100) {
            food.setPrice(food.getPrice() * (1 - food.getDiscount() * 0.01));
            container.add(food);
        }
    }
}
