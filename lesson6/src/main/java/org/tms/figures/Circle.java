package org.tms.figures;

public class Circle extends Figure {

    private int raduis;

    public Circle(int raduis) {
        this.raduis = raduis;
    }

    // метод Perimeter возвращает 0, потому что круг не имеет периметра
    @Override
    public int perimeter() {
        return 0;
    }

    // метод Square для нахождения площади круга
    @Override
    public double square() {
        return 3.14 * (raduis * raduis);
    }
}