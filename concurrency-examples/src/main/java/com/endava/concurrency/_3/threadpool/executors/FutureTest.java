package com.endava.concurrency._3.threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(String[] args) {
		
		
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			Future<?> future = service.submit(() -> System.out.println("future result!"));
	
			System.out.println("end");
			
			// you can comment the below section try{} catch and see if the future is still done? usually not
			
			try {
				System.out.println("thread sleep");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("future.isDone(): " + future.isDone());
		} finally {
			if (service != null)
				service.shutdown();
		}
		
	}

}
