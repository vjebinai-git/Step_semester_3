package topic_10.class_problems;

import java.util.Scanner;

public class StudentGradeAssignment {
    public static char getGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        }
        return 'F';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int marks = sc.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks");
            } else {
                System.out.println("Grade " + getGrade(marks));
            }
        }
    }
}