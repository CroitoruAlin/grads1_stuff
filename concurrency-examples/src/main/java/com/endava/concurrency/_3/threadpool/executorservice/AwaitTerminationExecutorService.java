package com.endava.concurrency._3.threadpool.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationExecutorService {

	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			// Add tasks to the thread executor
			final Future<?> responseCbl = service.submit(new CallableSleep());
			System.out.println(responseCbl.get());
		} finally {
			if (service != null) {
				service.shutdown();
				// try with a
				// service.shutdownNow();
			}
		}
		if (service != null) {
			service.awaitTermination(3, TimeUnit.SECONDS);
			// Check whether all tasks are finished
			if (service.isTerminated()) {
				System.out.println("All tasks finished");
			} else {
				System.out.println("At least one task is still running");
			}
		}

	}

}

class CallableSleep implements Callable<String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String call() throws Exception {
		Thread.sleep(10_000);
		return "Callable is cool";
	}

}
