package cars;

import utilities.CarSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarDriver {
    public static void main(String[] args){
        Car firstCar = new Car("1990", "infiniti", "M30");
        Car secondCar = new Car("2005", "Honda", "Civic");
        Car thirdCar = new Car("2008", "Honda", "CRV");
        Car fourthCar = new Car("1988", "Ford", "Mustang");
        Car fifthCar = new Car("2003", "Honda", "Accord");
        Car sixthCar = new Car("2016", "Volkswagen", "Jetta");
        Car seventhCar = new Car("1990", "Volvo", "850R");
        Car eighthCar = new Car("1988", "Volvo", "240D");
        Car ninthCar = new Car("1997", "Volvo", "960");

        System.out.println("step 1");

        CarSet carSet = new CarSet();
        carSet.addCars(firstCar, secondCar, thirdCar, fourthCar, fifthCar, sixthCar, seventhCar, eighthCar, ninthCar);

        System.out.println("step 2");

        String filePath = System.getProperty("user.home") + "/Desktop/cars.txt";

        Car.serializeAsCsv(carSet, filePath);

        System.out.println("step 3");

        CarSet clonedCarSet = Car.deserializeFromCsv("cars.txt");

        System.out.println("step 4");


        if (carSet.equals(clonedCarSet)) {
            System.out.println("carList and clonedCarList are equal");
        } else {
            System.out.println("carList and clonedCarList are not equal");
        }

    }
}

