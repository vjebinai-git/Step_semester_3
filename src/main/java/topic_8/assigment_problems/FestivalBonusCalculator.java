package topic_8.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

abstract class Employee {
    protected final String name;
    protected final double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    private static Employee createEmployee(String type, String name, double salary) {
        switch (type.toUpperCase(Locale.ROOT)) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN": return new InternEmployee(name, salary);
            default: throw new IllegalArgumentException("Invalid employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase(Locale.ROOT);
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = createEmployee(type, name, salary);
            double bonus = employee.calculateBonus();
            System.out.printf(Locale.US, "%s: %.2f%n", employee.name, bonus);
            totalBonus += bonus;
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}
