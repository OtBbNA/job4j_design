package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.car.Car;
import ru.job4j.ood.lsp.parking.car.CarAuto;
import ru.job4j.ood.lsp.parking.car.CarTruck;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpace;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpaceAuto;
import ru.job4j.ood.lsp.parking.parkingspace.ParkingSpaceTruck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ParkingAttendantTest {

    @Test
    void whenParkingThen() {
        CarTruck truck1 = new CarTruck();
        CarTruck truck2 = new CarTruck();
        CarTruck truck3 = new CarTruck();
        CarTruck truck4 = new CarTruck();
        truck1.setSize(4);
        truck2.setSize(8);
        truck3.setSize(5);
        truck4.setSize(2);
        CarAuto carAuto1 = new CarAuto();
        CarAuto carAuto2 = new CarAuto();
        CarAuto carAuto3 = new CarAuto();
        CarAuto carAuto4 = new CarAuto();
        ParkingSpaceTruck spaceTruck1 = new ParkingSpaceTruck();
        ParkingSpaceTruck spaceTruck2 = new ParkingSpaceTruck();
        ParkingSpaceTruck spaceTruck3 = new ParkingSpaceTruck();
        spaceTruck1.setSize(6);
        spaceTruck2.setSize(7);
        spaceTruck3.setSize(4);
        ParkingSpaceAuto spaceAuto1 = new ParkingSpaceAuto();
        ParkingSpaceAuto spaceAuto2 = new ParkingSpaceAuto();
        ParkingSpaceAuto spaceAuto3 = new ParkingSpaceAuto();
        ParkingSpaceAuto spaceAuto4 = new ParkingSpaceAuto();
        ParkingSpaceAuto spaceAuto5 = new ParkingSpaceAuto();
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        List<Car> cars = List.of(carAuto1, truck1, truck2, carAuto2,
                carAuto3, truck3, truck4, carAuto4);
        List<ParkingSpace> parkingSpaces = List.of(spaceAuto1, spaceTruck1,
                spaceAuto2, spaceAuto3,
                spaceTruck2, spaceAuto4,
                spaceAuto5, spaceTruck3);
        parkingAttendant.setCars(cars);
        parkingAttendant.setParkingSpaces(parkingSpaces);
        Map<Car, List<ParkingSpace>> expected = new HashMap<>();
        expected.put(carAuto1, parkingSpaces.subList(0, 1));
        expected.put(truck1, parkingSpaces.subList(7, 8));
        expected.put(truck2, parkingSpaces.subList(1, 4));
        expected.put(carAuto2, parkingSpaces.subList(5, 6));
        expected.put(carAuto3, parkingSpaces.subList(6, 7));
        expected.put(truck3, parkingSpaces.subList(4, 5));
        parkingAttendant.parking();
        Map<Car, List<ParkingSpace>> values = parkingAttendant.getSorted();
        for (Car car : values.keySet()) {
            for (int i = 0; i < values.get(car).size(); i++) {
                assertThat(values.get(car).get(i).getSize()).isEqualTo(expected.get(car).get(i).getSize());
            }
        }
    }
}