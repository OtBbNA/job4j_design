package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.car.Car;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpace;

import java.util.*;
import java.util.function.BiPredicate;

public class ParkingAttendant {

    private List<Car> cars = new ArrayList<>();
    private List<ParkingSpace> parkingSpaces = new ArrayList<>();
    private Map<Car, List<ParkingSpace>> sorted = new HashMap<>();

    public ParkingAttendant() {
    }

    public ParkingAttendant(List<Car> cars, List<ParkingSpace> parkingSpaces) {
        this.cars = cars;
        this.parkingSpaces = parkingSpaces;
    }

    public void parking() {
        for (Car car : cars) {
            if (cars.size() != sorted.size()) {
                List<ParkingSpace> indexes = getId(car, (carSize, parkingSize) -> (carSize == 1 && parkingSize == 1));
                if (indexes.size() == 1) {
                    ParkingSpace ps = indexes.get(0);
                    sorted.put(car, indexes);
                    ps.setOccupied(false);
                    continue;
                }
                indexes = getId(car, Objects::equals);
                if (indexes.size() == 1) {
                    ParkingSpace ps = indexes.get(0);
                    sorted.put(car, indexes);
                    ps.setOccupied(false);
                    continue;
                }
                indexes = getId(car, (carSize, parkingSize) -> (carSize > parkingSize));
                if (indexes.size() >= 1) {
                    for (ParkingSpace index : indexes) {
                        ParkingSpace ps = index;
                        ps.setOccupied(false);
                    }
                    sorted.put(car, indexes);
                    continue;
                }
            }
        }
    }

    private List<ParkingSpace> getId(Car car, BiPredicate<Integer, Integer> predicate) {
        ArrayList<ParkingSpace> rsl = new ArrayList<>();
        int carSize = car.getSize();
        int size = 0;
        for (int i = 0; i < parkingSpaces.size(); i++) {
            ParkingSpace ps = parkingSpaces.get(i);
            if (ps.getOccupied() && predicate.test(carSize, ps.getSize())) {
                rsl.add(ps);
                size += ps.getSize();
                if (carSize == 1 || carSize == ps.getSize()) {
                    break;
                } else if (size >= car.getSize()) {
                    break;
                }
            }
        }
        return rsl;
    }

    public Map<Car, List<ParkingSpace>> getSorted() {
        return sorted;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setParkingSpaces(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }
}
