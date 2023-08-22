/*
Создать три потока Т1, Т2 и Т3.
Реализовать выполнение поток в последовательности Т3 -> Т2 -> Т1 (используя метод join)
*/

package org.tms.threads;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {

        // создаем три объекта класса Thread (разными способами)
        Thread t3 = new CustomThread();
        Thread t2 = new Thread(new RunnableImpl());
        Thread t1 = new Thread(() -> System.out.println("Hello from thread " + Thread.currentThread().getName() + "."));

        // запускаем поток T3 и ждем его остановки
        t3.start();
        t3.join();

        // запускаем поток T2 и ждем его остановки
        t2.start();
        t2.join();

        // запускаем поток T1 и ждем его остановки
        t1.start();
        t1.join();
    }
}