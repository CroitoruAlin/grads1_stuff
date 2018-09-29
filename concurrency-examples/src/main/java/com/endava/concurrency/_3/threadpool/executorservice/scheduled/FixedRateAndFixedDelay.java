package com.endava.concurrency._3.threadpool.executorservice.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.endava.concurrency._1.threadcreation.runnable.PrintInput;

public class FixedRateAndFixedDelay {

	public static void main(final String[] args) throws InterruptedException {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			// Only Runnable is supported
			final Runnable task1 = new PrintInput("Task 1");
			final Runnable task2 = new PrintInput("Task 2");
			service.scheduleAtFixedRate(task1, 1, 2, TimeUnit.SECONDS);
			service.scheduleWithFixedDelay(task2, 3, 1, TimeUnit.SECONDS);
			service.schedule(task1,1,TimeUnit.SECONDS);
			Thread.sleep(4000);
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}

}
