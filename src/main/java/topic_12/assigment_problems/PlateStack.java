package topic_12.assigment_problems;

import java.util.Scanner;

public class PlateStack {

    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public PlateStack() {
        top = null;
        size = 0;
    }

    // Adds a new plate at the head of the chain.
    public void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Removes and returns the top plate.
    public String pop() {
        if (isEmpty()) {
            return null;
        }

        String removedPlate = top.data;
        top = top.next;
        size--;
        return removedPlate;
    }

    // Returns the top plate without removing it.
    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    private static void processOperation(PlateStack stack, String operation) {
        operation = operation.trim();

        if (operation.startsWith("push(") && operation.endsWith(")")) {
            String plate = operation.substring(5, operation.length() - 1).trim();
            stack.push(plate);
            System.out.println("push " + plate + " -> top " + stack.peek()
                    + ", size " + stack.getSize());

        } else if (operation.equals("pop()")) {
            String plate = stack.pop();

            if (plate == null) {
                System.out.println("pop -> stack is empty");
            } else {
                System.out.println("pop -> " + plate + ", size " + stack.getSize());
            }

        } else if (operation.equals("peek()")) {
            String plate = stack.peek();

            if (plate == null) {
                System.out.println("peek -> stack is empty");
            } else {
                System.out.println("peek -> " + plate);
            }

        } else if (operation.equals("isEmpty()")) {
            System.out.println("isEmpty -> " + stack.isEmpty());

        } else {
            System.out.println("Invalid operation: " + operation);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlateStack stack = new PlateStack();

        // Enter operations separated by commas.
        // Example: push(P1), push(P2), peek(), pop()
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] operations = input.split(",");

            for (String operation : operations) {
                processOperation(stack, operation);
            }
        }

        scanner.close();
    }
}

/*
Time Complexity of the linked-list stack:
- push(): O(1) - insert a node at the head.
- pop(): O(1) - remove the head node.
- peek(): O(1) - read the head node.
- isEmpty(): O(1) - check whether top is null.

Comparison with an array-based stack:
- With a regular array stack, push and pop are O(1) when capacity is
  available, but push can require O(n) when a dynamic array must resize.
- peek() and isEmpty() are O(1) for both implementations.
- A linked-list stack grows node by node and does not have a fixed capacity,
  but each node requires extra memory for its next reference.
*/