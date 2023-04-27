import cars.Car;
import org.junit.jupiter.api.Test;
import utilities.CarSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarDriverTest {
    @Test
    void carListEqualsCloneList(){

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


            Car.serializeAsCsv(carSet, "cars.txt");

            CarSet clonedCarSet = Car.deserializeFromCsv("cars.txt");

            assertEquals(carSet, clonedCarSet);
    }

    @Test
    void carListDoesNotEqualsCloneList(){

            Car firstCar = new Car("1990", "infiniti", "M30");
            Car secondCar = new Car("2005", "Honda", "Civic");
            Car thirdCar = new Car("2008", "Honda", "CRV");
            Car fourthCar = new Car("1988", "Ford", "Mustang");
            Car fifthCar = new Car("2003", "Honda", "Accord");
            Car sixthCar = new Car("2016", "Volkswagen", "Jetta");
            Car seventhCar = new Car("1990", "Volvo", "850R");
            Car eighthCar = new Car("1988", "Volvo", "240D");
            Car ninthCar = new Car("1997", "Volvo", "960");

            List<Car> carList = new ArrayList<>();
            List<Car> clonedCarList;
            carList.add(firstCar);
            carList.add(secondCar);
            carList.add(thirdCar);
            carList.add(fourthCar);
            carList.add(fifthCar);
            carList.add(sixthCar);
            carList.add(seventhCar);
            carList.add(eighthCar);
            carList.add(ninthCar);


            clonedCarList = new ArrayList<>();
            clonedCarList.add(firstCar);
            clonedCarList.add(secondCar);
            clonedCarList.add(thirdCar);
            clonedCarList.add(fourthCar);
            clonedCarList.add(fifthCar);
            clonedCarList.add(sixthCar);
            clonedCarList.add(seventhCar);
            clonedCarList.add(eighthCar);

            Set<Car> carSet = new HashSet<>(carList);
            Set<Car> clonedCarSet = new HashSet<>(clonedCarList);

            assertNotEquals(carSet, clonedCarSet);
    }


}