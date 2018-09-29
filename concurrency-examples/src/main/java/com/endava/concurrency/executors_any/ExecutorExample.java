package com.endava.concurrency.executors_any;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorExample {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(101));

    public static void main(String[] args) {

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final Integer number = i;
            tasks.add(() -> {
                System.out.println(Thread.currentThread().getName() + " hello" + number);
                return number;
            });
        }

        try {
            executor.invokeAny(tasks);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {


            executor.shutdown();
        }

       /* executor.execute(()->
        {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {


                System.out.println("Thread slept stopped");
            }
        });*/
        try {
            while (!executor.awaitTermination(1,TimeUnit.SECONDS))
            {
                System.out.println("At least one thread is executing");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
