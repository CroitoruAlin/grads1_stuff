package com.endava.concurrency._3.threadpool.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableVsRunnableExecutorService {

	public static void main(final String[] args) {
		ExecutorService service = null;
		try {
			// Callable Submit that returns a null and can throw Exception from
			// sleep
			service = Executors.newFixedThreadPool(2);
			final Future<?> responseCbl = service.submit(new CallableSleep());

			// Runnable cannot throw exception so it's force to catch it
			final Future<?> responseRnbl = service.submit(new RunnableSleep());
			service.shutdownNow();

			System.out.println(responseCbl.get());
			System.out.println("Runnable is " + responseRnbl.get());
		} catch (ExecutionException | InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}

	}
}

class RunnableSleep implements Runnable {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			System.out.println("Runnable cannot throw Exception");
		}
	}

}
