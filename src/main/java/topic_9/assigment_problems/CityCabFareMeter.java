package topic_9.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface NightService {
    double applyNightSurcharge(double fare);
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100.0;
    private final double distanceKm;

    public Cab(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    protected abstract double calculateDistanceFare();

    public abstract String getCabType();

    public final double calculateFare(boolean isNight) {
        double fare = Math.max(calculateDistanceFare(), MINIMUM_FARE);
        if (isNight && this instanceof NightService) {
            fare = ((NightService) this).applyNightSurcharge(fare);
        }
        return fare;
    }

    public final boolean supportsNightService() {
        return this instanceof NightService;
    }
}

class MiniCab extends Cab {
    public MiniCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateDistanceFare() {
        return getDistanceKm() * 10.0;
    }

    @Override
    public String getCabType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateDistanceFare() {
        return getDistanceKm() * 14.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }

    @Override
    public String getCabType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateDistanceFare() {
        return getDistanceKm() * 18.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }

    @Override
    public String getCabType() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Cab> trips = new ArrayList<>();
        List<Boolean> nightTrips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            boolean isNight = time.equals("NIGHT");

            Cab cab;
            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cab type: " + type);
            }
            trips.add(cab);
            nightTrips.add(isNight);
        }

        double total = 0.0;
        for (int i = 0; i < trips.size(); i++) {
            Cab cab = trips.get(i);
            boolean isNight = nightTrips.get(i);

            if (isNight && !cab.supportsNightService()) {
                System.out.printf("%s: night service not available%n", cab.getCabType());
            } else {
                double fare = cab.calculateFare(isNight);
                System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
