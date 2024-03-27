package ru.job4j.ood.srp.examples;

public class BarOCP {

    public String getFoodRecipe(String order) {
        String rsl = "";
        if (order.equals("burger")) {
            rsl = "Bread Lettuce Ham Cheese Cucumber Tomato Mayonnaise Butter";
        } else if (order.equals("Salad Caesar")) {
            rsl = "Green salad Chicken Tomato Parmesan cheese Garlic White bread Butter Salt";
        }
        return rsl;
    }
}
