package com.endava.concurrency._4.synchronization.cyclicbarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManagerNoCyclicBarrier {
	private void removeAnimals() {
		System.out.println("Removing animals");
	}

	private void cleanPen() {
		System.out.println("Cleaning the pen");
	}

	private void addAnimals() {
		System.out.println("Adding animals");
	}

	public void performTask() {
		removeAnimals();
		cleanPen();
		addAnimals();
	}

	public static void main(final String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			final LionPenManagerNoCyclicBarrier manager = new LionPenManagerNoCyclicBarrier();
			for (int i = 0; i < 4; i++) {
				service.submit(new Runnable() {
					@Override
					public void run() {
						manager.performTask();
					}
				});
			}
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}
}