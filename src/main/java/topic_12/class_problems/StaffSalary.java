package topic_12.class_problems;

import java.util.Scanner;

class Staff {
    private final String name;
    private final double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return 0.0;
    }

    public String getType() {
        return "Staff";
    }

    public double getTotalSalary() {
        return baseSalary + getBonus();
    }

    public void printDetails() {
        System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                name, getType(), baseSalary, getBonus(), getTotalSalary());
    }
}

class Teacher extends Staff {
    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 5000.0;
    }

    @Override
    public String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 2000.0;
    }

    @Override
    public String getType() {
        return "LabAssistant";
    }
}

public class StaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double baseSalary = sc.nextDouble();

            switch (type.toLowerCase()) {
                case "teacher":
                    staff[i] = new Teacher(name, baseSalary);
                    break;
                case "labassistant":
                    staff[i] = new LabAssistant(name, baseSalary);
                    break;
                default:
                    staff[i] = new Staff(name, baseSalary);
            }
        }

        for (Staff person : staff) {
            person.printDetails();
            grandTotal += person.getTotalSalary();
        }

        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
        sc.close();
    }
}

// Printing all salaries takes O(n) time, where n is the number of staff.
