package com.endava.concurrency._4.synchronization.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.endava.concurrency._1.threadcreation.runnable.PrintInput;

public class LionPenManagerCyclicBarrier {
	private void removeAnimals() {
		System.out.println("Removing animals");
	}

	private void cleanPen() {
		System.out.println("Cleaning the pen");
	}

	private void addAnimals() {
		System.out.println("Adding animals");
	}

	public void performTask(final CyclicBarrier c1, final CyclicBarrier c2) {
		try {
			removeAnimals();
			// magic
			c1.await();
			cleanPen();
			// magic
			c2.await();
			addAnimals();
		} catch (InterruptedException | BrokenBarrierException e) {
			// Handle checked exceptions here
		}
	}

	public static void main(final String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			final LionPenManagerCyclicBarrier manager = new LionPenManagerCyclicBarrier();
			final CyclicBarrier c1 = new CyclicBarrier(4);
			final CyclicBarrier c2 = new CyclicBarrier(4, new PrintInput("*** Pen Cleaned!"));

			for (int i = 0; i < 4; i++) {
				service.submit(new Runnable() {
					@Override
					public void run() {
						manager.performTask(c1, c2);
					}
				});
				// if(i==4) {
				// Thread.sleep(1000);
				// }
			}

		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}
}
