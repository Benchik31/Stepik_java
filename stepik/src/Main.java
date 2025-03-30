public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Triangle extends Shape {
    @Override
    double area() { return 0; }
    @Override
    double perimeter() { return 0; }
}

class IsoscelesTriangle extends Triangle {}
class EquilateralTriangle extends Triangle {}
class RightTriangle extends Triangle {}

class Quadrilateral extends Shape {
    @Override
    double area() { return 0; }
    @Override
    double perimeter() { return 0; }
}

class ConvexQuadrilateral extends Quadrilateral {}
class Parallelogram extends ConvexQuadrilateral {}
class Rectangle extends Parallelogram {}
class Square extends Rectangle {}
class Rhombus extends Parallelogram {}
class Trapezoid extends ConvexQuadrilateral {}

class Pentagon extends Shape {
    @Override
    double area() { return 0; }
    @Override
    double perimeter() { return 0; }
}

class Hexagon extends Shape {
    @Override
    double area() { return 0; }
    @Override
    double perimeter() { return 0; }
}

class Oval extends Shape {
    @Override
    double area() { return 0; }
    @Override
    double perimeter() { return 0; }
}

class Circle extends Oval {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}
