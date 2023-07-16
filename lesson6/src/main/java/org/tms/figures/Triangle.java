package org.tms.figures;

public class Triangle extends AbstractFigures {

    // метод Perimeter для нахождения периметра прямоугольного треугольника
    public int Perimeter(int sideA, int sideB, int sideC) {
        int result = sideA + sideB + sideC;
        System.out.println("Периметр треугольника со сторонами " + sideA + ", " + sideB + ", " + sideC + " равен " + result);
        return result;
    }

    // метод Square для нахождения площади прямоугольного треугольника
    public void Square(int sideA, int sideB) {
        float result = 0.5f * (sideA * sideB);
        System.out.println("Площадь прямоугольного треугольника с основанием " + sideA + " и высотой " + sideB + " равна " + result + "\n");
    }
}
