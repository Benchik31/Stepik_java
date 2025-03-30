package Figures.Triangles;
import Figures.Shape;

class Triangle extends Shape {
    @Override
    public double area() { return 0; }
    @Override
    public double perimeter() { return 0; }
}

class IsoscelesTriangle extends Triangle {}
class EquilateralTriangle extends Triangle {}
class RightTriangle extends Triangle {}