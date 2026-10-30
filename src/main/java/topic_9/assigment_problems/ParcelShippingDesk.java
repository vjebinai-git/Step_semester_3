package topic_9.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    private final double weightKg;
    private final double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public double getWeightKg() {
        return weightKg;
    }

    protected double getDeclaredValue() {
        return declaredValue;
    }

    public abstract double calculateCharge();

    public abstract String getType();

    public final double calculateInsuranceAmount() {
        return this instanceof Insurable
                ? ((Insurable) this).calculateInsurance()
                : 0.0;
    }

    public final double calculateTotal() {
        return calculateCharge() + calculateInsuranceAmount();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + 10.0 * getWeightKg();
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + 15.0 * getWeightKg();
    }

    @Override
    public double calculateInsurance() {
        return getDeclaredValue() * 0.02;
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + 10.0 * getWeightKg() + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return getDeclaredValue() * 0.02;
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weight, declaredValue));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weight, declaredValue));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weight, declaredValue));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
        }

        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsuranceAmount();
            double total = charge + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
