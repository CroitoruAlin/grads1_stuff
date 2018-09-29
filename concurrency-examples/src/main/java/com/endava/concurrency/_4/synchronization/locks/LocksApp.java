package com.endava.concurrency._4.synchronization.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksApp {

	public static void main(String[] args) {
		
		
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(10);
			System.out.println("begin");
			for(int i = 0; i < 10; i++) {
				final int j = i;
				service.execute(() -> performOperation("stuff i: " + j));
			}
			System.out.println("end");
		} finally {
			if (service != null)
				service.shutdown();
		}
		
		
	}
	
	
	public static void performOperation(String s) {
		Lock lock = new ReentrantLock();
		
		// if the lock and unlock are commented
		// the order of execution is almost random
		// if lock is in place, the execution will be in order
		
		lock.lock();

		try {
			System.out.println("s: " + s);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
