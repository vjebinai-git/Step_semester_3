package topic_10.class_problems;

import java.util.Scanner;

class Student {
    private final String name;
    private final int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / (double) marks.length;
    }

    public char calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        }
        return 'F';
    }

    public void printResult() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), calculateAverage(), calculateGrade());
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int i = 0; i < marks.length; i++) {
                if (!sc.hasNextInt()) {
                    throw new IllegalArgumentException("Each student must have exactly three marks.");
                }
                marks[i] = sc.nextInt();
            }

            new Student(name, marks).printResult();
        }
    }
}