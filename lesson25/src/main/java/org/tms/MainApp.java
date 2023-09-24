/*
Порождающий паттерн Одиночка (org.tms.Singleton)
*/

package org.tms;

public class MainApp {
    public static void main(String[] args) {

        Singleton firstTemp = Singleton.getInstance();
        Singleton secondTemp = Singleton.getInstance();

        System.out.println("Содержит ли переменная firstTemp тот же объект, что и переменная secondTemp: "
                + ((firstTemp == secondTemp) ? "содержит." : "не содержит."));
    }
}
