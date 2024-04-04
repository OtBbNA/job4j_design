package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.food.Food;

public class Warehouse extends AbstractStore {

    @Override
    public void add(Food food, double percent) {
        if (percent <= 25) {
            container.add(food);
        }
    }
}
