package org.tms.figures;

public class Circle extends AbstractFigures {

    // метод Perimeter возвращает 0, потому что круг не имеет периметра
    public int Perimeter(int sideA, int sideB, int sideC) {
        int result = 0;
        System.out.println("null");
        return result;
    }

    // метод Square для нахождения площади круга
    public void Square(int sideA, int sideB) {
        double result = 3.14 * (sideA * sideA);
        System.out.println("Площадь круга с радиусом " + sideA + " равна " + result + "\n");
    }
}
