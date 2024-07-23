package org.example.day5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureCommonAPI {
    public static void main(String[] args) {

        // runAsync: Executes a Runnable task asynchronously.
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running asynchronously");
        });

        // supplyAsync: Executes a Supplier task asynchronously and returns a result.
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Hello, World!";
        });

        // thenApply: Processes the result of a computation.
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + ", World!");

        // thenAccept: Consumes the result of a computation.
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(result -> System.out.println(result));

        // thenRun: Executes a Runnable after the computation is complete.
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenRun(() -> System.out.println("Computation finished!"));

        // thenCombine: Combines the result of two CompletableFuture instances.
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> " World");
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (s1, s2) -> s1 + s2);

        // thenCompose: Chains two CompletableFuture instances.
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + ", World!"));

        // allOf: Waits for all provided CompletableFuture instances to complete.
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);

        // anyOf: Returns a new CompletableFuture that is completed when any of the provided CompletableFuture instances complete.
        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future1, future2);

        // exceptionally: Handles exceptions thrown during computation.
        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong");
            }
            return "Success";
        }).exceptionally(ex -> "Failed: " + ex.getMessage());

        // handle: Handles both result and exceptions.
        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong");
            }
            return "Success";
        }).handle((result, ex) -> {
            if (ex != null) {
                return "Failed: " + ex.getMessage();
            } else {
                return result;
            }
        });

        // join: Blocks and waits for the computation to complete.
        future.join();

        // get: Similar to join, but it throws checked exceptions.
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //orTimeout: Completes exceptionally if the specified timeout is reached.
        CompletableFuture<String> future8 = CompletableFuture.supplyAsync(() -> {
            // long running task
            return "Result";
        }).orTimeout(1, TimeUnit.SECONDS);

        // completeOnTimeout: Completes with a specified value if the timeout is reached.
        CompletableFuture<String> future9 = CompletableFuture.supplyAsync(() -> {
            // long running task
            return "Result";
        }).completeOnTimeout("Timeout", 1, TimeUnit.SECONDS);

        // thenCombine: Combines the result of two CompletableFuture instances
        CompletableFuture<Integer> future10 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future11 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> combinedFuture1 = future10.thenCombine(future11, (a, b) -> a + b);

        // thenApplyAsync, thenAcceptAsync, thenRunAsync: These methods have asynchronous variants that allow you to specify an Executor to run the task in a different thread pool.
        CompletableFuture<String> future12 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(result -> result + ", World!");

    }
}
