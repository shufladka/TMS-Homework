package org.tms.figures;

public class Triangle extends Figure {

    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // метод Perimeter для нахождения периметра прямоугольного треугольника
    @Override
    public int perimeter() {
        return sideA + sideB + sideC;
    }

    // метод Square для нахождения площади прямоугольного треугольника
    @Override
    public double square() {
        return 0.5f * (sideA * sideB);
    }
}