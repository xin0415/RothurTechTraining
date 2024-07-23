package org.example.day5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    /*
    *   sync need to wait for result
    *   async doesn't need to wait for result
    *   1, Completable will start a new thread   .
    *   2. the main thread will be blocked when get() it called
    *   3. thenApplyAsync will start a new thread for operation
    *   4. thenCompose, then Combine    -   use to combine the result from two future
    *   5. allOf    -   if you want to use result from all the previous threads
    *   6. anyOf    -   if you only want to use one result from any of previous threads
    *
    * */
    private static Integer num=100;     //100+50, * 2->300
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // without any return
        /*
        System.out.println("main thread starts");
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("child thread starts working");
                Thread.sleep(5000);
                System.out.println("child thread done");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        System.out.println("before get");
        future.get();
        System.out.println("After get");
        System.out.println("main thread ends");
        */

        // with return
        /*
        System.out.println("main thread starts");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("child thread starts working");
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return "child thread is done";
        });

        System.out.println("Before get");
        System.out.println("task result: " + future.get());
        System.out.println("main thread ends");
        */

        // chain operation
/*
        System.out.println("main thread starts");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("start adding 50 to number");
            num += 50;
            return num;
        }).thenApply(val -> {
            return val * 2;
        });

//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("start adding 50 to number");
//            num += 50;
//            return num;
//        }).thenApply(val -> {
//            return val * 2;
//        }).thenApplyAsync(val -> val + 100).thenAccept(val -> {
//            System.out.println("this is the last step from mian thread");
//            System.out.println("result: " + (val - 1));
//        });

        System.out.println("task result: " + future.get());
        System.out.println("main thread ends");
        */

        //exception
        // first way to handle exception
        /*
        System.out.println("main thread starts");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 1 / 0;
            System.out.println("add 10 to num");
            num += 10;
            return num;
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return 404;
        });

        System.out.println("task result: " + future.get());
        System.out.println("main thread ends");
        */

        // second way to handle exception
        /*
        System.out.println("main thread starts");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            int result = 1 / 0;
            System.out.println("add 10 to num");
            num += 10;
            return num;
        }).handle((values, exception) -> {
            System.out.println("get into the handle method");
            if (exception == null) {
                values += 10;
                System.out.println("task is done");
                return values;
            } else {
                System.out.println("exception thrown" + exception.getMessage());
                return 400;
            }
        });
        System.out.println("task result: " + future.get());
        System.out.println("main thread ends");
        */
        //thenCompose, thenCombine
        //allOf, anyOf
    }
}
