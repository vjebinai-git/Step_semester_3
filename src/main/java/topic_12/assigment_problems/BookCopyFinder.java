package topic_12.assigment_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node build(String[] bookIds) {
        Node head = null;
        Node tail = null;

        for (String id : bookIds) {
            String cleanedId = id.trim();
            if (cleanedId.isEmpty()) {
                continue;
            }

            Node newNode = new Node(cleanedId);

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

    // One traversal finds both the first position and the total copies.
    static String find(Node head, String id) {
        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        Node current = head;

        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPosition == -1) {
                    firstPosition = position;
                }
                copies++;
            }

            current = current.next;
            position++;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            inputBuilder.append(scanner.nextLine()).append(" ");
        }
        scanner.close();

        String input = inputBuilder.toString().trim();

        // Accepts: trolley = B12 -> B07 -> B30, id = B07
        // The trolley and ID may also be supplied on separate lines.
        Matcher idMatcher = Pattern.compile("(?i)\\bid\\s*=\\s*([^,\\s]+)")
                                   .matcher(input);

        if (!idMatcher.find()) {
            System.out.println("Please provide the book ID to find.");
            return;
        }

        String targetId = idMatcher.group(1).trim();

        String trolleyPart = input.substring(0, idMatcher.start()).trim();
        trolleyPart = trolleyPart.replaceFirst("(?i)^\\s*trolley\\s*=\\s*", "");
        trolleyPart = trolleyPart.replaceAll("[\\[\\]]", "").trim();

        String[] bookIds = trolleyPart.split("\\s*->\\s*|\\s*,\\s*");
        Node head = build(bookIds);

        System.out.println(find(head, targetId));

        // Time complexity: O(n), where n is the number of nodes.
        // A linked list has no direct index access; reaching the middle
        // still requires following next references from the head.
        // Extra space used by find(): O(1).
    }
}
