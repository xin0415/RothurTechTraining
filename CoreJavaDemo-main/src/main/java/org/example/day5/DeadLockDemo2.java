package org.example.day5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo2 {
    public static void main(String[] args) {
        final ReentrantLock lock1 = new ReentrantLock();
        final ReentrantLock lock2 = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock1.lock();
                System.out.println("Thread 1: locked lock1");

                // Simulate some work with lock1
                Thread.sleep(100);

                // Try to acquire lock2
                lock2.lock();
                System.out.println("Thread 1: locked lock2");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                lock2.lock();
                System.out.println("Thread 2: locked lock2");

                // Simulate some work with lock2
                Thread.sleep(100);

                // Try to acquire lock1
                lock1.lock();
                System.out.println("Thread 2: locked lock1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
