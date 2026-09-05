class IdCard {

    String name;
    String regNo;
    int libraryBooks;

    IdCard(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;
    }
}

public class ObjectUsageDemo {

    public static void main(String[] args) {

        IdCard ravi =
            new IdCard("Ravi", "RA2311003010123");

        IdCard duplicate = ravi;

        IdCard karthik =
            new IdCard("Ravi", "RA2311003010123");

        duplicate.libraryBooks = 3;

        System.out.println(ravi.libraryBooks);

        System.out.println(ravi == duplicate);

        System.out.println(ravi == karthik);

        IdCard lost = null;

        // Uncomment this line to see NullPointerException
        // System.out.println(lost.name);

        System.out.println(lost == null);
    }
}