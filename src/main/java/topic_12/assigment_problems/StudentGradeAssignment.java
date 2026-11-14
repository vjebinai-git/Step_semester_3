package topic_12.assigment_problems;

import java.util.Scanner;

public class StudentGradeAssignment {
    public static char getGrade(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 75) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 40) return 'D';
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
        sc.close();
    }
}

// Time complexity: O(1) per student's grade; auxiliary space: O(1).
