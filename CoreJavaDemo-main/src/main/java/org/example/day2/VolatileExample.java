package org.example.day2;

public class VolatileExample extends Thread{
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Thread is running...");
        }
    }

    public void stopRunning() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();
        Thread.sleep(1000);
        thread.stopRunning();
        System.out.println("Thread has been requested to stop.");
    }
}
