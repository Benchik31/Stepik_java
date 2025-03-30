package Figures.Quadrilaterals;
import Figures.Shape;

class Quadrilateral extends Shape {
    @Override
    public double area() { return 0; }
    @Override
    public double perimeter() { return 0; }
}

class ConvexQuadrilateral extends Quadrilateral {}
class Parallelogram extends ConvexQuadrilateral {}
class Rectangle extends Parallelogram {}
class Square extends Rectangle {}
class Rhombus extends Parallelogram {}
class Trapezoid extends ConvexQuadrilateral {}