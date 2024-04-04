package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.food.Food;

public class Trash extends AbstractStore {

    @Override
    public void add(Food food, double percent) {
        if (percent >= 100) {
            container.add(food);
        }
    }
}
