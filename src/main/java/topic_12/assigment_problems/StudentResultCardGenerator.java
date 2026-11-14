package topic_12.assigment_problems;

import java.util.Scanner;

class ResultStudent {
    private final String name;
    private final int[] marks;

    ResultStudent(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) total += mark;
        return total / 3.0;
    }

    public char calculateGrade() {
        double average = calculateAverage();
        if (average >= 90) return 'A';
        if (average >= 75) return 'B';
        if (average >= 60) return 'C';
        if (average >= 40) return 'D';
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
        int studentCount = sc.nextInt();

        for (int i = 0; i < studentCount; i++) {
            String name = sc.next();
            int[] marks = new int[3];
            for (int j = 0; j < marks.length; j++) {
                marks[j] = sc.nextInt();
            }

            ResultStudent student = new ResultStudent(name, marks);
            student.printResult();
        }

        sc.close();
    }
}

// Time complexity: O(1) per student because each student has exactly 3 marks.
// Auxiliary space: O(1) per student.
