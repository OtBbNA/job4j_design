package ru.job4j.ood.lsp.control;

import ru.job4j.ood.lsp.store.*;
import ru.job4j.ood.lsp.food.Food;

import java.util.*;

public class ControlQuality  {

    private List<Food> foodList;
    private List<Store> stores;

    public ControlQuality(List<Food> foodList, List<Store> stores) {
        this.foodList = foodList;
        this.stores = stores;
    }

    public boolean distribution(Calendar date) {
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

    public void resort(Calendar date) {
        List<Food> bufferFoods = new ArrayList<>();
        for (Store store : stores) {
            bufferFoods.addAll(store.get());
        }
        foodList = new ArrayList<>();
        foodList.addAll(bufferFoods);
        distribution(date);
    }
}
