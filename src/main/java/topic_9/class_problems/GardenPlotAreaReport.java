package topic_9.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    private final String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract double calculateArea();

    public abstract String getShape();
}

class CirclePlot extends Plot {
    private final double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private final double length;
    private final double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private final double base;
    private final double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            switch (shape) {
                case "CIRCLE":
                    plots.add(new CirclePlot(owner, sc.nextDouble()));
                    break;
                case "RECTANGLE":
                    plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()));
                    break;
                case "TRIANGLE":
                    plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown plot shape: " + shape);
            }
        }

        double totalArea = 0.0;
        for (Plot plot : plots) {
            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}
