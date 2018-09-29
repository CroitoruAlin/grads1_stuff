package com.endava.concurrency._3.threadpool.executorservice.scheduled;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.endava.concurrency._1.threadcreation.runnable.PrintInput;

public class SimpleScheduleDelay {
	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			// Both Runnable and Callable is supported as always
			final Runnable task1 = new PrintInput("Hello Zoo");
			final Callable<String> task2 = new Monkey();
			final Future<?> result1 = service.schedule(task1, 5, TimeUnit.SECONDS);
			final Future<?> result2 = service.schedule(() -> "Monkey", 4, TimeUnit.SECONDS);
			System.out.println(result2.get());

		} finally {
			service.shutdown();
		}
	}
}

class Monkey implements Callable<String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String call() throws Exception {
		return "Monkey";
	}

}