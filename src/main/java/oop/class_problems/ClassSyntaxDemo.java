class Course {

    // Fields
    private String code;
    private String title;
    private int credits;
    private int gradePoint;

    // Constructor
    public Course(String code, String title, int credits, int gradePoint) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.gradePoint = gradePoint;
    }

    // Method
    public int creditPoints() {
        return credits * gradePoint;
    }

    // Method
    public void printCard() {
        System.out.println(
            code + " | " + title + " | "
            + credits + " credits | GP " + gradePoint
        );
    }
}

public class ClassSyntaxDemo {

    public static void main(String[] args) {

        Course dsa = new Course(
            "21CSC201J",
            "Data Structures",
            4,
            9
        );

        Course oops = new Course(
            "21CSC203P",
            "Advanced Programming Practice",
            3,
            8
        );

        dsa.printCard();
        oops.printCard();

        System.out.println(
            "Total credit points: "
            + (dsa.creditPoints() + oops.creditPoints())
        );
    }
}