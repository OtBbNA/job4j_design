package ru.job4j.ood.lsp.parking.parkingspace;

public class ParkingSpaceTruck extends ParkingSpace {

    public ParkingSpaceTruck() {
        size = (int) (Math.random() * 7) + 2;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
