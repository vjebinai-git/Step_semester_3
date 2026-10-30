package topic_8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

interface Customer {
    double calculateFinalAmount(double billAmount);
}

class StudentCustomer implements Customer {
    public double calculateFinalAmount(double billAmount) {
        return billAmount * 0.90;
    }
}

class StaffCustomer implements Customer {
    public double calculateFinalAmount(double billAmount) {
        return billAmount * 0.95;
    }
}

class GuestCustomer implements Customer {
    public double calculateFinalAmount(double billAmount) {
        return billAmount + 10.0;
    }
}

public class CanteenBillingCounter {
    private static Customer createCustomer(String type) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "STUDENT": return new StudentCustomer();
            case "STAFF": return new StaffCustomer();
            case "GUEST": return new GuestCustomer();
            default: throw new IllegalArgumentException("Invalid customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            double amount = sc.nextDouble();

            Customer customer = createCustomer(type);
            double finalAmount = customer.calculateFinalAmount(amount);
            System.out.printf(Locale.US, "%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
