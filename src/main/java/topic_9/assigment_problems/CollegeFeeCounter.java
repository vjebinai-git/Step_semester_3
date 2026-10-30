package topic_9.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class CollegeStudent {
    private final String name;

    public CollegeStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract double calculateTuition();

    protected double calculateAdditionalFees() {
        return 0.0;
    }

    public final double calculateTotalFee() {
        double transportFee = this instanceof BusUser
                ? ((BusUser) this).getTransportFee()
                : 0.0;
        return calculateTuition() + calculateAdditionalFees() + transportFee;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    private static final double TUITION = 40000.0;
    private static final double TRANSPORT_FEE = 12000.0;

    public DayScholar(String name) {
        super(name);
    }

    @Override
    protected double calculateTuition() {
        return TUITION;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends CollegeStudent {
    private static final double TUITION = 40000.0;
    private static final double HOSTEL_FEE = 60000.0;

    public Hosteller(String name) {
        super(name);
    }

    @Override
    protected double calculateTuition() {
        return TUITION;
    }

    @Override
    protected double calculateAdditionalFees() {
        return HOSTEL_FEE;
    }
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    private static final double SCHOLARSHIP_TUITION = 20000.0;
    private static final double TRANSPORT_FEE = 12000.0;

    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    protected double calculateTuition() {
        return SCHOLARSHIP_TUITION;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<CollegeStudent> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown student type: " + type);
            }
        }

        double totalCollected = 0.0;
        for (CollegeStudent student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
