package org.tms.figures;

public class Rectangle extends Figure {

    private int lenght;
    private int width;

    public Rectangle(int lenght, int width) {
        this.lenght = lenght;
        this.width = width;
    }

    // метод Perimeter для нахождения периметра прямоугольника
    @Override
    public int perimeter() {
        return lenght + lenght + width + width;
    }

    // метод Square для нахождения площади прямоугольника
    @Override
    public double square() {
        return lenght * width;
    }
}