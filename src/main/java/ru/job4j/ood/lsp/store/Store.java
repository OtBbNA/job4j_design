package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.food.Food;

import java.util.List;

public interface Store {

    void add(Food food, double percent);
    List<Food> get();
}
