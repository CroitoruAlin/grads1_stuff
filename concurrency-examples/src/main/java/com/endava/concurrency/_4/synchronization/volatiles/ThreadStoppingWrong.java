package com.endava.concurrency._4.synchronization.volatiles;

public class ThreadStoppingWrong {

	public static void main(String[] args) {
			
		// ==========
		class StoppableThread extends Thread {
			private boolean stopped; // defaults to false

			@Override
			public void run() {
				synchronized (this) {
					while (!stopped)
						System.out.println("running");
				}
			}

			synchronized void stopThread() {
				stopped = true;
			}
		}
		// ==========
		
		StoppableThread thd = new StoppableThread();
		thd.start();
		try {
			Thread.sleep(1000); // sleep for 1 second
		} catch (InterruptedException ie) {
			// silent fall
		}
		thd.stopThread();
	}

}
/**
 * You've correctly synchronized access to stopped, but take a closer look at the synchronized block 
 * in the run() method. Notice the while loop. This loop is unending because the thread executing the 
 * loop has acquired the lock to the current StoppableThread object (via synchronized(this)), 
 * and any attempt by the default main thread to call stopThread() on this object will cause the default 
 * main thread to block because the default main thread needs to acquire the same lock.
 */


