class SrmStudent {

    // Instance members
    String name;
    String regNo;

    // Static members
    static String university =
        "SRM Institute of Science and Technology";

    static String campus =
        "SRM Kattankulathur";

    static int admissionCount = 0;

    // Constructor
    SrmStudent(String name) {
        this.name = name;

        admissionCount++;

        this.regNo = "RA23110030101" + admissionCount;
    }

    // Instance method
    void printIdCard() {
        System.out.println(
            regNo + " | " + name + " | " + campus
        );
    }

    // Static method
    static void printTotalAdmissions() {
        System.out.println(
            "Students admitted so far: "
            + admissionCount
        );

        // System.out.println(name);
        // ERROR: static method cannot directly access
        // an instance variable.
    }
}

public class StaticDemo {

    public static void main(String[] args) {

        SrmStudent ravi =
            new SrmStudent("Ravi");

        SrmStudent meera =
            new SrmStudent("Meera");

        ravi.printIdCard();

        meera.printIdCard();

        SrmStudent.printTotalAdmissions();

        // Static value is shared by all objects
        SrmStudent.campus = "SRM Ramapuram";

        ravi.printIdCard();

        meera.printIdCard();
    }
}