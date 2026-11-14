package topic_12.assigment_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LateComersInTheLine {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Inserts a new student at the beginning of the line.
    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    // Inserts a new student at the end of the line.
    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);

        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static Node buildStartingLine(String line) {
        line = line.trim();

        if (line.isEmpty() || line.equalsIgnoreCase("(empty)")) {
            return null;
        }

        line = line.replaceFirst("(?i)^\\s*line\\s*=\\s*", "");
        line = line.replace("->", ",").trim();

        String[] names = line.split(",");
        Node head = null;

        for (String name : names) {
            String cleanedName = name.trim();
            if (!cleanedName.isEmpty()) {
                head = addLast(head, cleanedName);
            }
        }

        return head;
    }

    static void printLine(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        Node head = buildStartingLine(scanner.nextLine());

        Pattern operationPattern =
                Pattern.compile("(?i)\\s*(addFirst|addLast)\\s*\\(\\s*([^()]+?)\\s*\\)\\s*");

        int operationCount = 0;

        while (scanner.hasNextLine()) {
            String operation = scanner.nextLine().trim();

            if (operation.isEmpty()) {
                continue;
            }

            Matcher matcher = operationPattern.matcher(operation);
            if (!matcher.matches()) {
                continue;
            }

            String type = matcher.group(1);
            String name = matcher.group(2).trim();

            if (type.equalsIgnoreCase("addFirst")) {
                head = addFirst(head, name);
            } else {
                head = addLast(head, name);
            }

            operationCount++;
        }

        scanner.close();

        if (operationCount < 1 || operationCount > 20) {
            System.out.println("Invalid number of operations.");
            return;
        }

        printLine(head);

        // addFirst: O(1) time, because only the new node and head are updated.
        // addLast: O(n) time, because the list is traversed to find the last node.
    }
}
