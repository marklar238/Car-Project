import cars.Car;
import cars.CarDriver;
import org.junit.jupiter.api.Test;
import utilities.CarSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void testSettersAndGetters(){
            Car car = new Car("1990", "infiniti", "M30");
            assertEquals("1990", car.getYear());
            assertEquals("infiniti", car.getMake());
            assertEquals("M30", car.getModel());
    }

    @Test
    public void testEquals(){
            Car car1 = new Car("1990", "infinit", "M30");
            Car car2 = new Car("1990", "infinit", "M30");
            Car car3 = new Car("2005", "Honda", "Civic");
            Car car4 = new Car("1988", "Volvo", "240");
            assertTrue(car1.equals(car2));
            assertFalse(car3.equals(car4));
            assertFalse(car1.equals(car3));
    }

}
class CarDriverTest {
    @Test
    public void testCarDriverMain() {
        // set up test data
        Car firstCar = new Car("1990", "infiniti", "M30");
        Car secondCar = new Car("2005", "Honda", "Civic");
        Car thirdCar = new Car("2008", "Honda", "CRV");
        Car fourthCar = new Car("1988", "Ford", "Mustang");
        Car fifthCar = new Car("2003", "Honda", "Accord");
        Car sixthCar = new Car("2016", "Volkswagen", "Jetta");
        Car seventhCar = new Car("1990", "Volvo", "850R");
        Car eighthCar = new Car("1988", "Volvo", "240D");
        Car ninthCar = new Car("1997", "Volvo", "960");
        CarSet expectedCarSet = new CarSet();
        expectedCarSet.addCars(firstCar, secondCar, thirdCar, fourthCar, fifthCar, sixthCar, seventhCar, eighthCar, ninthCar);
        String filePath = System.getProperty("user.home") + "/Desktop/cars.txt";

        // execute the main method of the CarDriver class
        CarDriver.main(new String[] {});

        // check the output of the main method
        CarSet actualCarSet = Car.deserializeFromCsv(filePath);
        assertEquals(expectedCarSet, actualCarSet);
    }

}