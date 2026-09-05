class HostelRoom {

    String roomNo;
    int beds;
    int occupied;

    void allot(String studentName) {
        if (occupied < beds) {
            occupied++;

            System.out.println(
                studentName + " allotted to room " + roomNo
            );
        } else {
            System.out.println(
                "Room " + roomNo + " is full - "
                + studentName + " goes on the waiting list"
            );
        }
    }
}

public class BlueprintDemo {

    public static void main(String[] args) {

        HostelRoom room214 = new HostelRoom();
        room214.roomNo = "C-214";
        room214.beds = 3;

        HostelRoom room507 = new HostelRoom();
        room507.roomNo = "C-507";
        room507.beds = 2;

        room214.allot("Ravi");
        room214.allot("Karthik");
        room507.allot("Meera");

        System.out.println(
            "C-214 occupied: " + room214.occupied
        );

        System.out.println(
            "C-507 occupied: " + room507.occupied
        );
    }
}