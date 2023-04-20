//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Car implements Comparable<Car> {
    private String make;
    private String model;
    private String year;

    public Car() {
        this("1930", "ford", "model-T");
    }

    public Car(String year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getYear() {
        return this.year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static void serializeAsCsv(List<Car> cars, String fileName) {
        Path desktopPath = Paths.get(System.getProperty("user.home"), "Desktop");
        Path filePath = desktopPath.resolve(fileName);
        Set<Car> existingCars = new HashSet<>();
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] carAttributes = line.split(",");
                if (carAttributes.length != 3) {
                    throw new IllegalArgumentException("Invalid data format");
                } else {
                    String year = carAttributes[0].trim();
                    String make = carAttributes[1].trim();
                    String model = carAttributes[2].trim();
                    Car car = new Car(year, make, model);
                    existingCars.add(car);
                }
            }
        } catch (IOException e) {
            // ignore, file doesn't exist yet
        }

        try {
            for (Car car : cars) {
                if (!existingCars.contains(car)) {
                    String carAttributes = prePrintCsv(car);
                    System.out.println(carAttributes);
                    Files.write(filePath, (carAttributes + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    existingCars.add(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String prePrintCsv(Car car) {
        String var10000 = car.getYear();
        return var10000 + "," + car.getMake() + "," + car.getModel();
    }

    public static List<Car> deserializeFromCsv(String fileName) {
        Path desktopPath = Paths.get(System.getProperty("user.home"), "Desktop");
        Path filePath = desktopPath.resolve(fileName);
        List<Car> carList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] carAttributes = line.split(",");
                if (carAttributes.length != 3) {
                    throw new IllegalArgumentException("Invalid data format");
                }
                String year = carAttributes[0].trim();
                String make = carAttributes[1].trim();
                String model = carAttributes[2].trim();
                carList.add(new Car(year, make, model));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Car car = (Car)o;
            return Objects.equals(this.make, car.make) && Objects.equals(this.model, car.model) && Objects.equals(this.year, car.year);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.make, this.model, this.year);
    }

    public int compareTo(Car other) {
        return this.year.compareTo(other.year);
    }
}
