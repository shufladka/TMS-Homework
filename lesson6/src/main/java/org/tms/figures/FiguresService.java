package org.tms.figures;

public class FiguresService {

        public String typeOfFigure;
        public int sideA;
        public int sideB;
        public int sideC;

        // конструктор для круга
        public FiguresService(String typeOfFigure, int sideA) {
                this.typeOfFigure = typeOfFigure;
                this.sideA = sideA;
        }

        // конструктор для прямоугольника
        public FiguresService(String typeOfFigure, int sideA, int sideB) {
                this.typeOfFigure = typeOfFigure;
                this.sideA = sideA;
                this.sideB = sideB;
        }

        // конструктор для треугольника
        public FiguresService(String typeOfFigure, int sideA, int sideB, int sideC) {
                this.typeOfFigure = typeOfFigure;
                this.sideA = sideA;
                this.sideB = sideB;
                this.sideC = sideC;
        }

        public String getTypeOfFigure() {
                return typeOfFigure;
        }

        public int getSideA() {
                return sideA;
        }

        public int getSideB() {
                return sideB;
        }

        public int getSideC() {
                return sideC;
        }
}