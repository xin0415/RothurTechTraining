package org.example.day4;

import java.util.concurrent.*;

public class ThreadTest {
    /*
    *   1. Thread only can accept Runnable
    *   2. start method will call run() or call()
    *   3. if no more thread available, it will put into BlockingQueue
    *   4. the blockingQueue is full, it will create temporary thread
    *   5. if both blockingQueue and temporary thread are full, it will trigger RejectedExecutionHandler handler. it will reject the task
    *   6. each handler has four rejection policy: AbortPolicy, CallerRunPolicy, DiscardPolicy, DescardOldestPolicy
    *   7. AbortPolicy(default);        if you didn't define the rejection policy, it will use the abortPolicy. it will abort task and throw RejectedExecutionException
    *   8. DiscardPolicy: it will discard the task
    *   9. CallerRunPolicy: which method is caller, caller will run the policy. if caller is main, main will run the task
    *   10. DescardOldestPolicy: it will remove oldest node in the blockingqueue and put the newest task node into blockingQueue. BlockingQueue follows FIFO
    *   11. when the thread is done, it will release thread. then run the new thread task
    *   12. if not thread task come in, it will take task from blockingQueue
    *   13. keepAliveTime means how long keep the temporary thread alive, remove the temporary thread if timeout
    *   14. Fixed thread pool doesn't have temporary thread and used LinkedBlockingQueue. LinkedBlockingQueue doesn't have size limit which will cause out of memory error
    *   15. Single thread pool only has one thread in thread pool. and used LinkedBlockingQueue, same issue
    *   16: Cached thread pool. pool size is 0. Integer.MAX_VALUE size of temporary thread. Always use temporary thread. used SynchronousQueue. Integer.MAX_VALUE size of temporary thread cause the out of memory
    *   17. schedule thread pool. set up the pool size and Integer.MAX_VALUE size of temporary thread. Used delayedWorkQueue() and have schedule method. Integer.MAX_VALUE size of temporary thread cause the out of memory
    *   18. don't recommend to use predefine thread pool
    *
    * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1=new MyThread();
        t1.start();

        Thread t2=new Thread(new RunnableThread());
        t2.start();

        FutureTask task = new FutureTask(new CallableThread());         // FutureTask can take callable. FutureTask implements Runnable interface, so it can pass to Thread
        Thread t3 = new Thread(task);
        t3.start();
        System.out.println(task.get());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i=1; i<=10; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is working on " + finalI + " task");
            });
        }
        threadPool.shutdown();

        ExecutorService tp1=Executors.newFixedThreadPool(2);        // don't have temporary thread
        ExecutorService tp2=Executors.newSingleThreadExecutor();
        ExecutorService tp3=Executors.newCachedThreadPool();
        ExecutorService tp4=Executors.newScheduledThreadPool(5);
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread is created by extending Thread Class");
    }
}
class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread is created by implementing Runnable interface");
    }
}

class CallableThread implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " thread is created by implementing Callable interface");
        return 123;
    }
}
