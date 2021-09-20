package ua.repeta.car.util;

import ua.repeta.car.model.Car;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class CarUtils {
    public static Optional<Car> findByNumberPlate(List<Car> cars, String numberPlate) {
        return cars.stream()
            .filter(it -> it.getNumberPlate().equals(numberPlate))
            .findFirst();
    }

    public static List<Car> findByModelAndOlderThanYears(List<Car> cars, String model, int years) {
        return cars.stream()
            .filter(it -> it.getModel().equals(model))
            .filter(it -> Year.now().minusYears(it.getYear().getValue()).getValue() > years)
            .collect(Collectors.toList());
    }

    public static List<Car> findByYearAndPriceHigherThanAmount(List<Car> cars, Year year, int amount) {
        return cars.stream()
            .filter(it -> it.getYear().equals(year))
            .filter(it -> it.getPrice() > amount)
            .collect(Collectors.toList());
    }
}
