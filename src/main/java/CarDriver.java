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

        List<Car> carList = new ArrayList<>();
        List<Car> clonedCarList;
        carList.add(secondCar);
        carList.add(firstCar);
        carList.add(thirdCar);
        carList.add(fourthCar);
        carList.add(fifthCar);
        carList.add(sixthCar);
        carList.add(seventhCar);
        carList.add(eighthCar);
        carList.add(ninthCar);

        System.out.println("step 2");


        Car.serializeAsCsv(carList, "cars.txt");

        System.out.println("step 3");

        clonedCarList = Car.deserializeFromCsv("cars.txt");

        System.out.println("step 4");

        Set<Car> carSet = new HashSet<>(carList);
        Set<Car> clonedCarSet = new HashSet<>(clonedCarList);

        System.out.println("step 5");

        if (carSet.equals(clonedCarSet)) {
            System.out.println("carList and clonedCarList are equal");
        } else {
            System.out.println("carList and clonedCarList are not equal");
        }

    }
}

