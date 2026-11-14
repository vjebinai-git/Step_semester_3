package topic_12.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private final String name;
    private int mark1;
    private int mark2;
    private int mark3;

    Student(String name) {
        this.name = name;
    }

    public boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
            return false;
        }
        mark1 = a;
        mark2 = b;
        mark3 = c;
        return true;
    }

    public int getTotal() {
        return mark1 + mark2 + mark3;
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    public char getGrade() {
        double average = getAverage();
        if (average >= 80) return 'A';
        if (average >= 70) return 'B';
        if (average >= 60) return 'C';
        if (average >= 40) return 'D';
        return 'F';
    }

    @Override
    public String toString() {
        return String.format("%s total=%d avg=%.2f grade=%c",
                name, getTotal(), getAverage(), getGrade());
    }
}

public class ClassReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student student = new Student(name);
            if (student.setMarks(a, b, c)) {
                students.add(student);
            } else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }

        int passes = 0;
        // Each pass moves a larger total one position toward the front.
        for (int end = students.size() - 1; end > 0; end--) {
            boolean swapped = false;
            for (int j = end; j > 0; j--) {
                if (students.get(j).getTotal() > students.get(j - 1).getTotal()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j - 1));
                    students.set(j - 1, temp);
                    swapped = true;
                    break; // One adjacent move per pass, as described in the example.
                }
            }
            passes++;
            if (!swapped) break;
            end++; // Repeat the remaining adjacent moves until the list is ordered.
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        System.out.println("Sorted in " + passes + " passes");
        sc.close();
    }
}

// Bubble-sort best case is O(n); worst case is O(n^2).
