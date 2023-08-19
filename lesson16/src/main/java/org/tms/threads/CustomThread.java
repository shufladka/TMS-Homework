package org.tms.threads;

public class CustomThread extends Thread {

    public CustomThread() {
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Hello from thread " + thread.getName() + ".");
    }
}