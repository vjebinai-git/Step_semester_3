package topic_8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

interface Vehicle {
    double calculateParkingCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateParkingCharge(int hours) {
        return 10.0 * hours;
    }
}

class Car implements Vehicle {
    public double calculateParkingCharge(int hours) {
        return 30.0 + 20.0 * (hours - 1);
    }
}

class Truck implements Vehicle {
    public double calculateParkingCharge(int hours) {
        return Math.max(100.0, 50.0 * hours);
    }
}

public class CampusParkingChargeCalculator {
    private static Vehicle createVehicle(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "BIKE": return new Bike();
            case "CAR": return new Car();
            case "TRUCK": return new Truck();
            default: throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            int hours = sc.nextInt();

            Vehicle vehicle = createVehicle(type);
            double charge = vehicle.calculateParkingCharge(hours);
            System.out.printf(Locale.US, "%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
