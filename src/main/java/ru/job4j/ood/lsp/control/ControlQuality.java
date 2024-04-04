package ru.job4j.ood.lsp.control;

import ru.job4j.ood.lsp.store.*;
import ru.job4j.ood.lsp.food.Food;

import java.util.*;

public class ControlQuality  {

    private List<Food> foodList;
    private Calendar date;
    private List<Store> stores;

    public ControlQuality(List<Food> foodList, Calendar date, List<Store> stores) {
        this.foodList = foodList;
        this.date = date;
        this.stores = stores;
    }

    public boolean distribution() {
        boolean result = false;
        for (Food food : foodList) {
            double daysGood = food.getExpiryDate().getTime().getTime() - food.getCreateDate().getTime().getTime();
            double daysNow = date.getTime().getTime() - food.getCreateDate().getTime().getTime();
            for (Store store : stores) {
                store.add(food, (daysNow * 100) / daysGood);
                result = true;
                }
            }
        return result;
    }
}
