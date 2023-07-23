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
        Figure[] figures = new Figure[5];
        figures[0] = new Triangle(3,4,5);
        figures[1] = new Rectangle(10,10);
        figures[2] = new Rectangle(15,22);
        figures[3] = new Circle(12);
        figures[4] = new Triangle(8,6,10);

        // инициализация переменной для подсчета суммы периметров всех фигур
        int sumOfPerimeters = 0;

        // проход по массиву фигур для подсчета суммы периметров всех фигур
        for (Figure figure : figures) {
            sumOfPerimeters += figure.perimeter();
        }

        // вывод результата вычисления суммы периметров всех фигур на консоль
        System.out.println("Сумма периметров всех фигур равна " + sumOfPerimeters);
    }
}