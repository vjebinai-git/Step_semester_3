import java.util.*;

interface Transport {
    double calculateFare(double distance, double peakHourFactor);
}

class BusTransport implements Transport {
    public double calculateFare(double distance, double peakHourFactor) {
        return Math.min(2.0 + 0.10 * distance, 10.0);
    }
}

class TrainTransport implements Transport {
    public double calculateFare(double distance, double peakHourFactor) {
        return 3.0 + 0.15 * distance;
    }
}

class MetroTransport implements Transport {
    public double calculateFare(double distance, double peakHourFactor) {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    private static Transport createTransport(String type) {
        switch (type.toUpperCase()) {
            case "BUS": return new BusTransport();
            case "TRAIN": return new TrainTransport();
            case "METRO": return new MetroTransport();
            default: throw new IllegalArgumentException("Invalid transport type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            double peakHourFactor = type.equals("METRO") ? sc.nextDouble() : 1.0;

            Transport transport = createTransport(type);
            double fare = transport.calculateFare(distance, peakHourFactor);
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
