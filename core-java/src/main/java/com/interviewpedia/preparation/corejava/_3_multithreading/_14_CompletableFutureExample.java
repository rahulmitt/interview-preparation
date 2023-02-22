package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.concurrent.CompletableFuture;

public class _14_CompletableFutureExample {
    public static void main(String[] args) {
        HelloWorldService service = new HelloWorldService();
        long start = System.currentTimeMillis();
        System.out.println(example0(service) + " :: took " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println(example1(service) + " :: took " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        System.out.println(example2(service) + " :: took " + (System.currentTimeMillis() - start) + " ms");
    }

    private static String example0(HelloWorldService service) {
        return service.hello().toUpperCase() + " " + service.world().toUpperCase() + "!! " + service.message() + "!";
    }

    private static String example1(HelloWorldService service) {
        return CompletableFuture.supplyAsync(service::hello)
                .thenCombine(CompletableFuture.supplyAsync(service::world), (prev, curr) -> prev + " " + curr + "!!")
                .thenApply(String::toUpperCase)
                .thenCombine(CompletableFuture.supplyAsync(service::message), (prev, curr) -> prev + " " + curr + "!")
                .join();
    }

    private static String example2(HelloWorldService service) {
        return CompletableFuture.supplyAsync(service::hello)
                .thenCompose(prev -> CompletableFuture.supplyAsync(() -> prev + " " + service.world() + "!!"))
                .thenApply(String::toUpperCase)
                .thenCompose(prev -> CompletableFuture.supplyAsync(() -> prev + " " + service.message() + "!"))
                .join();
    }

    private static class HelloWorldService {
        String hello() {
            delay(1000);
            return "Hello";
        }

        String world() {
            delay(1000);
            return "World";
        }

        String message() {
            delay(1000);
            return "What a bright and sunny day";
        }

        static void delay(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
