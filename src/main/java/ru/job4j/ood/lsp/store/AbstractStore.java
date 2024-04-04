package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.food.Food;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    List<Food> container = new ArrayList<>();

    @Override
    public List<Food> get() {
        return container;
    }
}
