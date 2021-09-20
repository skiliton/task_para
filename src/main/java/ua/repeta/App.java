package ua.repeta;

import ua.repeta.car.model.Car;

import java.time.Year;
import java.util.List;

import static ua.repeta.car.util.CarUtils.*;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final List<Car> cars = List.of(
        new Car(1,"BMW", "X6", Year.of(2019),70_00, "KA 1234 BC"),
        new Car(2,"BMW", "X6", Year.of(2019),90_000, "SH 6853 DA"),
        new Car(3,"BMW", "X6", Year.of(2020),110_000, "DB 5687 BC"),
        new Car(4,"Audi", "A3", Year.of(2016),20_000, "KA 4373 GB"),
        new Car(5,"Audi", "A3", Year.of(2018),30_000, "CH 4543 AD"),
        new Car(6,"Toyota", "Camry", Year.of(2015),20_000, "OS 2345 DG"),
        new Car(7,"Mercedes", "S-Class", Year.of(2019),120_000, "UD 2355 KN"),
        new Car(8,"Nissan", "GTR", Year.of(2015),90_000, "DG 9573 CG")
    );

    public static void main( String[] args )
    {
        System.out.println("findByNumberPlate:");
        findByNumberPlate(cars, "CH 4543 AD")
            .ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Car with such number plate was not found")
            );

        System.out.println("\nfindByModelAndOlderThanYears:");
        findByModelAndOlderThanYears(cars, "X6",1)
            .forEach(System.out::println);

        System.out.println("\nfindByYearAndPriceHigherThanAmount:");
        findByYearAndPriceHigherThanAmount(cars, Year.of(2019),80_000)
            .forEach(System.out::println);
    }
}
