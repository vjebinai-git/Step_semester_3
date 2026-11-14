package topic_12.assigment_problems;

import java.util.Scanner;

public class CancelABooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Removes only the first occurrence of the booking number.
    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            return null;
        }

        // Handle the head separately: removing it takes O(1) time.
        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;

        // Stop at the node immediately before the first matching node.
        while (current.next != null) {
            if (current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        return head;
    }

    static Node buildChain(String chainText) {
        chainText = chainText.trim();

        if (chainText.isEmpty() || chainText.equalsIgnoreCase("null")) {
            return null;
        }

        String[] bookings = chainText.split("\\s*->\\s*");
        Node head = null;
        Node tail = null;

        for (String booking : bookings) {
            booking = booking.trim();
            if (booking.isEmpty() || booking.equalsIgnoreCase("null")) {
                continue;
            }

            Node newNode = new Node(booking);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    static void printChain(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Expected input:
        // bookings = 104 -> 101 -> 107 -> 101
        // cancel = 101
        String firstLine = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        String secondLine = scanner.hasNextLine() ? scanner.nextLine().trim() : "";

        String chainText = firstLine;
        String bookingToCancel = secondLine;

        if (firstLine.toLowerCase().startsWith("bookings")) {
            int equalsIndex = firstLine.indexOf('=');
            if (equalsIndex >= 0) {
                chainText = firstLine.substring(equalsIndex + 1).trim();
            }
        }

        if (secondLine.toLowerCase().startsWith("cancel")) {
            int equalsIndex = secondLine.indexOf('=');
            if (equalsIndex >= 0) {
                bookingToCancel = secondLine.substring(equalsIndex + 1).trim();
            }
        }

        Node head = buildChain(chainText);

        boolean found = false;
        for (Node current = head; current != null; current = current.next) {
            if (current.data.equals(bookingToCancel)) {
                found = true;
                break;
            }
        }

        head = removeFirst(head, bookingToCancel);

        if (!found) {
            System.out.println(bookingToCancel + " not found");
        }
        printChain(head);

        scanner.close();
    }
}

/*
Time Complexity:
- Booking is at the head: O(1), because the head reference is updated directly.
- Booking is at the end: O(n), because we traverse the chain to find the
  node immediately before the last node.
- Booking is absent: O(n), because the entire chain must be checked.
- Overall: O(n) time and O(1) extra space for removeFirst().
*/