package com.jarvis.springbootappcache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestMutithreading {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
            TestMutithreading t = new TestMutithreading();
            long start = System.currentTimeMillis();
            t.testCompletableFuture();
            long totaltime = System.currentTimeMillis() - start;
            System.out.println("Total time elapsed: "+ totaltime);
    }

    public void testExecutorService() throws ExecutionException, InterruptedException {
        List<Future> futList = new ArrayList<>();
        for(int i=0; i<50 ; i++){
            Future fut = executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("executing the task with thread:" + Thread.currentThread().getName());
            });
            futList.add(fut);
        }

        for(Future fut : futList){
            fut.get();
        }

        System.out.println("now with thread:"+ Thread.currentThread().getName());
        executorService.shutdown();
    }

    public void testCompletableFuture() throws ExecutionException, InterruptedException {
        List<CompletableFuture> futList = new ArrayList<>();
        for(int i=0; i<50 ; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("executing the task with thread:" + Thread.currentThread().getName());
            }, executorService);
            futList.add(completableFuture);

//            Thread.sleep(1000);
//            System.out.println("executing the task with thread:" + Thread.currentThread().getName());
        }

        for(CompletableFuture fut : futList){
            fut.join();
        }
        System.out.println("now with thread:"+ Thread.currentThread().getName());
        executorService.shutdown();
    }


}
