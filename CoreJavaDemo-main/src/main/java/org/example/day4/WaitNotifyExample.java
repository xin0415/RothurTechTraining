package org.example.day4;

public class WaitNotifyExample {
    private final Object lock = new Object();

    public void waitingMethod() {
        synchronized (lock) {
            try {
                System.out.println("Waiting...");
                lock.wait();  // Current thread waits and releases the lock
                System.out.println("Notified and resumed!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void notifyingMethod() {
        synchronized (lock) {
            System.out.println("Notifying...");
            lock.notify();  // Notifies one waiting thread
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyExample example = new WaitNotifyExample();

        Thread t1 = new Thread(example::waitingMethod);
        Thread t2 = new Thread(example::notifyingMethod);

        t1.start();
        Thread.sleep(1000);  // Ensure t1 starts and waits
        t2.start();

        t1.join();
        t2.join();
    }
}

