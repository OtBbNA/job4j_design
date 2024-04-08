package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.car.Car;
import ru.job4j.ood.lsp.parking.car.CarGenerator;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpace;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpaceGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ParkingAttendant {

    private List<Car> cars;
    private List<ParkingSpace> parkingSpaces;

    public ParkingAttendant(List<Car> cars, List<ParkingSpace> parkingSpaces) {
        this.cars = cars;
        this.parkingSpaces = parkingSpaces;
    }

    public Map<Car, ParkingSpace> parking() {
        Map<Car, ParkingSpace> rsl = new HashMap<>();
        return rsl;
    }
}
