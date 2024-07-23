package org.example.day5;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo2 {
    public static void main(String[] args) {
        ProducerConsumerModel2 sharedObject = new ProducerConsumerModel2();
        List<Producer2> producers = new ArrayList<>();
        List<Consumer2> consumers = new ArrayList<>();
        for (int i=1; i<=5; i++) producers.add(new Producer2("producer-" + i, sharedObject));
        for (int i=1; i<=5; i++) consumers.add(new Consumer2("consumer-" + i, sharedObject));

        for (Producer2 p: producers) p.start();
        for (Consumer2 c: consumers) c.start();
    }

}
class ProducerConsumerModel2 {
    private Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 3;
    private Random myRandom = new Random();

    // for producer
    public synchronized void put() throws InterruptedException {

        while (queue.size() == capacity) {
            System.out.println(Thread.currentThread().getName() + " wait, queue is full");
            wait();
        }
        int tempValue = myRandom.nextInt(100);
        queue.offer(tempValue);
        System.out.println(Thread.currentThread().getName() + " put " + tempValue);
        notifyAll();
    }

    // for consumer
    public synchronized void take() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " wait, queue is empty");
            wait();
        }
        int tempValue = queue.poll();
        System.out.println(Thread.currentThread().getName() + " take " + tempValue);
        notifyAll();
    }

}

class Producer2 extends Thread{
    private String name;
    ProducerConsumerModel2 pc;
    public Producer2(String name, ProducerConsumerModel2 sharedObject) {
        super(name);
        pc = sharedObject;
    }

    @Override
    public void run() {
        try {
            pc.put();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ;
    }
}

class Consumer2 extends Thread {
    private String name;
    ProducerConsumerModel2 pc;
    public Consumer2(String name, ProducerConsumerModel2 sharedObject) {
        super(name);
        pc = sharedObject;
    }
    @Override
    public void run() {
        try {
            pc.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ;
    }


}