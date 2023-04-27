package utilities;

import cars.Car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarSet extends HashSet<Car> implements Set<Car> {

    public void addCars(Car... cars) {
        this.addAll(Arrays.asList(cars));
    }

}