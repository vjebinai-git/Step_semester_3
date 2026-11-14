package topic_12.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusRouteStops {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Builds a singly linked list in the same order as the given stops.
    static Node build(String[] stops) {
        Node head = null;
        Node tail = null;

        for (String stop : stops) {
            Node newNode = new Node(stop);

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

    // Prints every stop, followed by null to show the end of the chain.
    static void printRoute(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        scanner.close();

        // Accepts input such as:
        // stops = [Tambaram, Guindy, TNagar, Central]
        // or: Tambaram Guindy TNagar Central
        input = input.replaceFirst("(?i)^\\s*stops\\s*=\\s*", "");
        input = input.replace("[", "").replace("]", "").trim();

        String[] stops;
        if (input.isEmpty()) {
            stops = new String[0];
        } else if (input.contains(",")) {
            String[] parts = input.split(",");
            List<String> cleanedStops = new ArrayList<>();

            for (String part : parts) {
                String stop = part.trim();
                if (!stop.isEmpty()) {
                    cleanedStops.add(stop);
                }
            }

            stops = cleanedStops.toArray(new String[0]);
        } else {
            stops = input.split("\\s+");
        }

        if (stops.length < 1 || stops.length > 50) {
            System.out.println("Invalid number of stops.");
            return;
        }

        Node head = build(stops);
        printRoute(head);

        Node current = head;
        String first = head.data;
        String last = first;
        int count = 0;

        while (current != null) {
            count++;
            last = current.data;
            current = current.next;
        }

        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);

        // Building: O(n) time, where n is the number of stops.
        // Printing: O(n) time, because each node is visited once.
        // Finding count, first, and last: O(n) time.
    }
}
