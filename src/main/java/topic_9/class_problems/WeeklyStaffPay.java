package topic_9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class StaffMember {
    private final String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private final double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private final double hours;
    private final double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends StaffMember {
    private final double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<StaffMember> staff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FULLTIME":
                    staff.add(new FullTimeStaff(name, sc.nextDouble()));
                    break;
                case "HOURLY":
                    staff.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()));
                    break;
                case "INTERN":
                    staff.add(new InternStaff(name, sc.nextDouble()));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }

        double totalPayroll = 0.0;
        for (StaffMember member : staff) {
            double pay = member.calculatePay();
            System.out.printf("%s: %.2f%n", member.getName(), pay);
            totalPayroll += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
