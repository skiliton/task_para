package ua.repeta.car.util;

import ua.repeta.car.model.Car;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public final class CarUtils {

    private CarUtils() {
    }

    public static Car findByNumberPlate(List<Car> cars, String numberPlate) {
        for (var car : cars) {
            if(car.getNumberPlate().equals(numberPlate)){
                return car;
            }
        }
        return null;
    }

    public static List<Car> findByModelAndOlderThanYears(List<Car> cars, String model, int years) {
        var res = new ArrayList<Car>();
        for(var car : cars) {
            if(
                car.getModel().equals(model) &&
                Year.now().minusYears(car.getYear().getValue()).getValue() > years
            ){
                res.add(car);
            }
        }
        return res;
    }

    public static List<Car> findByYearAndPriceHigherThanAmount(List<Car> cars, Year year, int amount) {
        var res = new ArrayList<Car>();
        for(var car : cars) {
            if(
                car.getYear().equals(year) &&
                car.getPrice() > amount
            ){
                res.add(car);
            }
        }
        return res;
    }
}
