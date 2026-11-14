package topic_12.class_problems;

import java.util.Scanner;

public class HostelElectricityBill {
    private static long calculateBill(int units) {
        long energyCharge;

        if (units <= 100) {
            energyCharge = units * 3L;
        } else if (units <= 200) {
            energyCharge = 100L * 3 + (units - 100L) * 5;
        } else {
            energyCharge = 100L * 3 + 100L * 5 + (units - 200L) * 8;
        }

        return energyCharge + 50;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rooms = sc.nextInt();
        int billedRooms = 0;
        long grandTotal = 0;

        for (int i = 0; i < rooms; i++) {
            String roomNumber = sc.next();
            int units = sc.nextInt();

            if (units < 0) {
                System.out.println(roomNumber + ": invalid reading");
            } else {
                long bill = calculateBill(units);
                System.out.println(roomNumber + ": " + units + " units, bill " + bill);
                billedRooms++;
                grandTotal += bill;
            }
        }

        System.out.println("Rooms billed " + billedRooms + ", total " + grandTotal);
        sc.close();
    }
}

// Billing n rooms takes O(n) time.
