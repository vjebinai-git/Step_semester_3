package topic_9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    private final double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    protected abstract double calculateBaseFare();

    public final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public abstract String getMode();
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return getDistanceKm() * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return getDistanceKm() * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + getDistanceKm() * 4.0;
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distanceKm = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings.add(new BusBooking(distanceKm));
                    break;
                case "TRAIN":
                    bookings.add(new TrainBooking(distanceKm));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightBooking(distanceKm));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown travel mode: " + mode);
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.getMode(), booking.calculateTotal());
        }
        sc.close();
    }
}
