package ru.job4j.ood.lsp.food;

import java.util.Calendar;

public class Food {

    String name;
    Calendar createDate;
    Calendar expiryDate;
    double price;
    int discount;

    public Food() {
    }

    public Food(String name, Calendar createDate, Calendar expiryDate, double price, int discount) {
        this.name = name;
        if (createDate.after(expiryDate)) {
            throw new IllegalArgumentException("product create or expiry date are illegal");
        }
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expiryDate=" + expiryDate.getTime()
                + ", createDate=" + createDate.getTime()
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
