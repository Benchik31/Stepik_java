package Figures;

public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
}
class Pentagon extends Shape {
    @Override
    public double area() { return 0; }
    @Override
    public double perimeter() { return 0; }
}

class Hexagon extends Shape {
    @Override
    public double area() { return 0; }
    @Override
    public double perimeter() { return 0; }
}

class Oval extends Shape {
    @Override
    public double area() { return 0; }
    @Override
    public double perimeter() { return 0; }
}

class Circle extends Oval {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
