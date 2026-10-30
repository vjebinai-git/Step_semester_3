package topic_9.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class MovieTicket {
    private static final double CONVENIENCE_FEE = 20.0;
    private final int count;

    public MovieTicket(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    protected abstract double getSeatPrice();

    public abstract String getSeatType();

    public final double calculateAmount() {
        return count * (getSeatPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    protected double getSeatPrice() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    protected double getSeatPrice() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    protected double getSeatPrice() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<MovieTicket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            switch (seat) {
                case "REGULAR":
                    bookings.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerTicket(count));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown seat type: " + seat);
            }
        }

        double total = 0.0;
        for (MovieTicket ticket : bookings) {
            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
