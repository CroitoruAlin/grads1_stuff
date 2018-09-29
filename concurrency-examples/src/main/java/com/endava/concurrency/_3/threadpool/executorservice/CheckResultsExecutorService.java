package com.endava.concurrency._3.threadpool.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResultsExecutorService {

	static int counter = 0;

	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			// Runnable submit
			final Future<?> result = service.submit(() -> {
				for (int i = 0; i < 50_000_000; i++) {
					CheckResultsExecutorService.counter++;
				}
			});
			// Wait until result is available or 1ms have passed (whichever first)
			result.get(1, TimeUnit.MILLISECONDS);
			// result.get();
			System.out.println("Reached!");
		} catch (final TimeoutException e) {
			System.out.println("Not reached in time");
			System.out.println(counter);
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}
}

class RunnableCount implements Runnable {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		for (int i = 0; i < 5_000_000; i++) {
			CheckResultsExecutorService.counter++;
		}
	}

}