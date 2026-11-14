package topic_12.class_problems;

import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);

    String getMode();
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public String getMode() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount * 1.02;
    }

    public String getMode() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }

    public String getMode() {
        return "UPI";
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];
        double totalProcessed = 0.0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();

            switch (mode.toLowerCase()) {
                case "card":
                    payments[i] = new CardPayment();
                    break;
                case "upi":
                    payments[i] = new UpiPayment();
                    break;
                default:
                    payments[i] = new CashPayment();
            }
        }

        for (int i = 0; i < n; i++) {
            double processed = payments[i].processPayment(amounts[i]);
            double fee = processed - amounts[i];
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                    payments[i].getMode(), amounts[i], fee, processed);
            totalProcessed += processed;
        }

        System.out.printf("Total Amount Processed: %.1f%n", totalProcessed);
        sc.close();
    }
}

// Processing all n payments takes O(n) time.
