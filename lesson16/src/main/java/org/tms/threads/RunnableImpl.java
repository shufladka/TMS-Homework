package org.tms.threads;

public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Hello from thread " + thread.getName() + ".");
    }
}
