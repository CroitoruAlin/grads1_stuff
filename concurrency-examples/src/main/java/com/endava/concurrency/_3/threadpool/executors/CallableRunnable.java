package com.endava.concurrency._3.threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableRunnable {

	public static void main(String[] args) {

		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			service.submit(() -> {Thread.sleep(1000); return null;});

			// it is seen as runnable
//			service.submit(() -> {Thread.sleep(1000);});

			System.out.println("end");

		} finally {
			if (service != null)
				service.shutdown();
		}
		
		
		
		
		
	}

}
