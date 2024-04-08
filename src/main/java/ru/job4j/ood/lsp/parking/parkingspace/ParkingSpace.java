package ru.job4j.ood.lsp.parking.parkingspace;

public abstract class ParkingSpace {
    int size;
    boolean occupied = true;
    public int getSize() {
        return size;
    }
    public boolean getOccupied() {
        return occupied;
    }
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
