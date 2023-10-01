/*
Паттерн decorator
*/

package org.tms;

public class MainApp {
    public static void main(String[] args) {

        DataReader dataReader = new LogDataReader(new BufferDataReader(new RandomDataReader()));

        for (int i = 0; i < 20; i++) {
            System.out.println(dataReader.read());
        }
    }
}