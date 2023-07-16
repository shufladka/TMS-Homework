package org.tms.figures;

public class Rectangle extends AbstractFigures {

    // метод Perimeter для нахождения периметра прямоугольника
    public int Perimeter(int sideA, int sideB, int sideC) {
        int result = sideA + sideA + sideB + sideB;
        System.out.println("Периметр прямоугольника с длиной " + sideA + " и шириной " + sideB + " равен " + result);
        return result;
    }

    // метод Square для нахождения площади прямоугольника
    public void Square(int sideA, int sideB) {
        int result = sideA * sideB;
        System.out.println("Площадь прямоугольника с длиной " + sideA + " и шириной " + sideB + " равна " + result + "\n");
    }
}
