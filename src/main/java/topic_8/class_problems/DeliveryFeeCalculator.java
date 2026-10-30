import java.util.*;

interface DeliveryService {
    double calculateFee(double weight, double distance, double customsFee);
}

class StandardDelivery implements DeliveryService {
    public double calculateFee(double weight, double distance, double customsFee) {
        return 5.0 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery implements DeliveryService {
    public double calculateFee(double weight, double distance, double customsFee) {
        return 15.0 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery implements DeliveryService {
    public double calculateFee(double weight, double distance, double customsFee) {
        return 25.0 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryFeeCalculator {
    private static DeliveryService createDelivery(String type) {
        switch (type.toUpperCase()) {
            case "STANDARD": return new StandardDelivery();
            case "EXPRESS": return new ExpressDelivery();
            case "INTERNATIONAL": return new InternationalDelivery();
            default: throw new IllegalArgumentException("Invalid delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customsFee = type.equals("INTERNATIONAL") ? sc.nextDouble() : 0.0;

            DeliveryService delivery = createDelivery(type);
            double fee = delivery.calculateFee(weight, distance, customsFee);
            System.out.printf(Locale.US, "%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
