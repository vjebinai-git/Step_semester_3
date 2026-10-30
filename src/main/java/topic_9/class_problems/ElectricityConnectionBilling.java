package topic_9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class ElectricityConnection {
    private final double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public double getUnits() {
        return units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double units = getUnits();
        return units <= 100 ? units * 5.0 : 100 * 5.0 + (units - 100) * 7.0;
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return getUnits() * 8.0 + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(getUnits() * 6.0, 1000.0);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown connection type: " + type);
            }
        }

        double total = 0.0;
        for (ElectricityConnection connection : connections) {
            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n", connection.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
