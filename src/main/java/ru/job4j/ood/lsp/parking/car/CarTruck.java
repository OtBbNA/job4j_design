package ru.job4j.ood.lsp.parking.car;

public class CarTruck extends Car {

    public CarTruck() {
        size = (int) (Math.random() * 7) + 2;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
