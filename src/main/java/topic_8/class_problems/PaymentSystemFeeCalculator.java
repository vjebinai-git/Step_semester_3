package topic_8.class_problems;

import java.util.*;

interface PaymentMethod {
    double calculateFinalAmount(double amount);
}

class CardPayment implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransferPayment implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount;
    }
}

public class PaymentSystemFeeCalculator {
    private static PaymentMethod createPaymentMethod(String type) {
        switch (type.toUpperCase()) {
            case "CARD": return new CardPayment();
            case "WALLET": return new WalletPayment();
            case "BANKTRANSFER": return new BankTransferPayment();
            default: throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            PaymentMethod payment = createPaymentMethod(type);
            double adjustedAmount = payment.calculateFinalAmount(amount);
            System.out.printf(Locale.US, "%s: %.2f%n", type, adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
