package com.endava.concurrency._4.synchronization.synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {

//	private Integer sheepCount = 0;
//
//	public void incrementAndReport() {
//		System.out.println(Thread.currentThread().getName() + "try increment");
//		synchronized (sheepCount) {
//			System.out.println("Sheepcounter: "+ ++sheepCount + " ");
//
//			System.out.println(Thread.currentThread().getName()+ "incremented");
//		}
//		System.out.println(Thread.currentThread().getName()+"exit");
//	}

    private AtomicInteger sheepCount= new AtomicInteger(0);
    public void incrementAndReport()
    {
        synchronized (sheepCount)
        {
            System.out.println(sheepCount.incrementAndGet()+ Thread.currentThread().getName());
        }
    }

	// private final AtomicInteger sheepCount = new AtomicInteger(0);
	//
	// public void incrementAndReport() {
	// System.out.print(sheepCount.addAndGet(1) + " ");
	// }

	public static void main(final String[] args) {
		final SheepManager manager = new SheepManager();

		ExecutorService service = null;
		try {
			service = Executors.newCachedThreadPool();
			service.execute(new SheepRunner(manager));
			service.execute(new SheepRunner(manager));
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}

}

class SheepRunner implements Runnable {

	SheepManager sheepManager;

	SheepRunner(final SheepManager sheepManager) {
		this.sheepManager = sheepManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		for (int i = 0; i < 13; i++) {
			sheepManager.incrementAndReport();
		}
	}
}
