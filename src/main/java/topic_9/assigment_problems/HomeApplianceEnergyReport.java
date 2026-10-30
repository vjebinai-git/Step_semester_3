package topic_9.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface SaverMode {
    double reduceEnergyUsage(double units);
}

abstract class Appliance {
    private static final double COST_PER_UNIT = 8.0;
    private final double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    protected abstract double getPowerWatts();

    public abstract String getApplianceType();

    public final double calculateUnits(boolean saverRequested) {
        double units = getPowerWatts() * hours / 1000.0;
        if (saverRequested && this instanceof SaverMode) {
            units = ((SaverMode) this).reduceEnergyUsage(units);
        }
        return units;
    }

    public final double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }

    public final boolean supportsSaverMode() {
        return this instanceof SaverMode;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 150.0;
    }

    @Override
    public String getApplianceType() {
        return "FRIDGE";
    }
}

class ACAppliance extends Appliance implements SaverMode {
    public ACAppliance(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 1500.0;
    }

    @Override
    public double reduceEnergyUsage(double units) {
        return units * 0.75;
    }

    @Override
    public String getApplianceType() {
        return "AC";
    }
}

class TVAppliance extends Appliance {
    public TVAppliance(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 100.0;
    }

    @Override
    public String getApplianceType() {
        return "TV";
    }
}

class WasherAppliance extends Appliance implements SaverMode {
    public WasherAppliance(double hours) {
        super(hours);
    }

    @Override
    protected double getPowerWatts() {
        return 500.0;
    }

    @Override
    public double reduceEnergyUsage(double units) {
        return units * 0.75;
    }

    @Override
    public String getApplianceType() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Appliance> appliances = new ArrayList<>();
        List<Boolean> saverRequests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            Appliance appliance;
            switch (type) {
                case "FRIDGE":
                    appliance = new FridgeAppliance(hours);
                    break;
                case "AC":
                    appliance = new ACAppliance(hours);
                    break;
                case "TV":
                    appliance = new TVAppliance(hours);
                    break;
                case "WASHER":
                    appliance = new WasherAppliance(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown appliance: " + type);
            }
            appliances.add(appliance);
            saverRequests.add(saverRequested);
        }

        double totalCost = 0.0;
        for (int i = 0; i < appliances.size(); i++) {
            Appliance appliance = appliances.get(i);
            boolean saverRequested = saverRequests.get(i);

            if (saverRequested && !appliance.supportsSaverMode()) {
                System.out.printf("%s: saver mode not supported%n", appliance.getApplianceType());
            } else {
                double units = appliance.calculateUnits(saverRequested);
                double cost = appliance.calculateCost(units);
                System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                        appliance.getApplianceType(), units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
