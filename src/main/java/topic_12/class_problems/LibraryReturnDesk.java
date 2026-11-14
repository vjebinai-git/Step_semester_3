package topic_12.class_problems;

import java.util.Scanner;

public class LibraryReturnDesk {
    private static final int CAPACITY = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.useDelimiter("\\A").hasNext() ? sc.next() : "";
        String[] commands = input.split(",");

        String[] pile = new String[CAPACITY];
        int top = -1;

        String[] line = new String[CAPACITY];
        int front = 0;
        int rear = 0;
        int size = 0;

        for (String raw : commands) {
            String command = raw.trim();
            if (command.isEmpty()) continue;

            String[] parts = command.split("\\s+", 2);
            String action = parts[0].toUpperCase();
            String value = parts.length > 1 ? parts[1].trim() : "";

            switch (action) {
                case "RETURN":
                    if (top == CAPACITY - 1) {
                        System.out.println(value + " rejected: pile is full");
                    } else {
                        pile[++top] = value;
                        System.out.println(value + " placed on pile");
                    }
                    break;

                case "SHELVE":
                    if (top == -1) {
                        System.out.println("pile is empty");
                    } else {
                        System.out.println("shelved " + pile[top]);
                        pile[top--] = null;
                    }
                    break;

                case "WAIT":
                    if (size == CAPACITY) {
                        System.out.println(value + " rejected: line is full");
                    } else {
                        line[rear] = value;
                        rear = (rear + 1) % CAPACITY;
                        size++;
                        System.out.println(value + " joined the line");
                    }
                    break;

                case "SERVE":
                    if (size == 0) {
                        System.out.println("no one waiting");
                    } else {
                        System.out.println("served " + line[front]);
                        line[front] = null;
                        front = (front + 1) % CAPACITY;
                        size--;
                    }
                    break;

                default:
                    System.out.println("unknown command: " + command);
            }
        }
        sc.close();
    }
}

// RETURN, SHELVE, WAIT and SERVE each take O(1) time.
