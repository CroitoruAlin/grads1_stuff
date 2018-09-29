package com.endava.concurrency._3.threadpool.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddDataExecutorServiceCallable {
	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			// Callable submit (it returns something)
			final Future<Integer> result = service.submit(new CallableSum(30, 11));
			System.out.println(result.get());
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}
}

class CallableSum implements Callable<Integer> {

	private final int value1;
	private final int value2;

	CallableSum(final int value1, final int value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer call() throws Exception {
		return value1 + value2;
	}

}
