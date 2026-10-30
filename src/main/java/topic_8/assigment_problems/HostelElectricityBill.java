package topic_8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

interface Room {
    double calculateBill(int units);
}

class SingleRoom implements Room {
    public double calculateBill(int units) {
        return units * 8.0;
    }
}

class SharedRoom implements Room {
    private final int occupants;

    SharedRoom(int occupants) {
        if (occupants < 2 || occupants > 4) {
            throw new IllegalArgumentException("Occupants must be between 2 and 4.");
        }
        this.occupants = occupants;
    }

    public double calculateBill(int units) {
        return units * 6.0 / occupants;
    }
}

class AcRoom implements Room {
    public double calculateBill(int units) {
        return units * 10.0 + 200.0;
    }
}

public class HostelElectricityBill {
    private static Room createRoom(String type, int occupants) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "SINGLE": return new SingleRoom();
            case "SHARED": return new SharedRoom(occupants);
            case "AC": return new AcRoom();
            default: throw new IllegalArgumentException("Invalid room type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            int units = sc.nextInt();
            int occupants = type.equals("SHARED") ? sc.nextInt() : 0;

            Room room = createRoom(type, occupants);
            double bill = room.calculateBill(units);
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
