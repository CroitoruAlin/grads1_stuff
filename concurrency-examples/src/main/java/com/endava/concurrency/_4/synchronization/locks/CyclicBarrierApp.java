package com.endava.concurrency._4.synchronization.locks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierApp {

	public static void main(String[] args) {
		
		
		ExecutorService executor = Executors.newFixedThreadPool(10);

		// wait 3 threads then write down "barrier removed"
		CyclicBarrier barrier = new CyclicBarrier(3, () -> {System.out.println("barrier removed"); });
		
	
		Thread t0 = new Thread(new CyclicBarrierRunnable(barrier));
		Thread t1 = new Thread(new CyclicBarrierRunnable(barrier));
		Thread t2 = new Thread(new CyclicBarrierRunnable(barrier));

		t0.start();
		t1.start();
		//t2.start();
		
	}
	
	
	static class CyclicBarrierRunnable implements Runnable{

	    CyclicBarrier barrier = null;

	    public CyclicBarrierRunnable(CyclicBarrier barrier) {
	    	this.barrier = barrier;
	    }

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println("runnable -> barrier.await()");
				barrier.await();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    
	    
	}
	
	

}
