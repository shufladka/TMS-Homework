/*
1. Написать иерархию классов «Фигуры».
Фигура -> Треугольник -> Прямоугольник -> Круг.
Реализовать ф-ю подсчета площади для каждого типа фигуры и подсчет периметра.
Создать массив из 5 фигур.
Вывести на экран сумму периметра всех фигур в массиве.
*/

package org.tms.figures;

public class MainApp {
    public static void main(String[] args) {

        // создание массива из пяти фигур
        FiguresService[] figuresService = new FiguresService[5];
        figuresService[0] = new FiguresService("triangle", 3,4,5);
        figuresService[1] = new FiguresService("rectangle", 10,10);
        figuresService[2] = new FiguresService("rectangle", 15,22);
        figuresService[3] = new FiguresService("circle", 12);
        figuresService[4] = new FiguresService("triangle", 8,6,10);

        // создание объектов абстрактного класса AbstractFigures для работы с треугольником, прямоугольником и кругом
        AbstractFigures triangle = new Triangle();
        AbstractFigures rectangle = new Rectangle();
        AbstractFigures circle = new Circle();

        // инициализация переменной для подсчета суммы периметров всех фигур
        int sumOfPerimeters = 0;

        // проход по массиву фигур
        for(int i = 0; i < figuresService.length; i++) {
            switch (figuresService[i].getTypeOfFigure()) {
                case "triangle":
                    sumOfPerimeters += triangle.Perimeter(figuresService[i].getSideA(),figuresService[i].getSideB(), figuresService[i].getSideC());
                    triangle.Square(figuresService[i].getSideA(),figuresService[i].getSideB());
                    break;
                case "rectangle":
                    sumOfPerimeters += rectangle.Perimeter(figuresService[i].getSideA(),figuresService[i].getSideB(), 0);
                    rectangle.Square(figuresService[i].getSideA(),figuresService[i].getSideB());
                    break;
                case "circle":
                    circle.Square(figuresService[i].getSideA(),0);
                    break;
                default:
                    System.out.println("Произошла неизвестная ошибка.");
                    break;
            }
        }

        // вывод результата вычисления суммы периметров всех фигур на консоль
        System.out.println("Сумма периметров всех фигур равна " + sumOfPerimeters);
    }
}