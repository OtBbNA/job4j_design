package ru.job4j.ood.srp.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BarOCPPet extends BarOCP {

    private Map<Integer, String> map = new HashMap<>();

    public void getOrder(ArrayList<String> arr) {
        int i = 0;
        while (arr.size() >= i) {
            map.put(i++, getFoodRecipe(arr.get(i)));
        }
    }
}
