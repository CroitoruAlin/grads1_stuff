package com.endava.concurrency._4.synchronization.volatiles;

public class ThreadStop {

	public static void main(String[] args) {
		//==========================
		class StoppableThread extends Thread {
			private volatile boolean stopped; // defaults to false

			@Override
			public void run() {
				while (!stopped)
					System.out.println("running");
			}

			void stopThread() {
				stopped = true;
			}
		}
		//=========================
		
		
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
 * Because stopped has been marked volatile, each thread will access the main memory copy of this variable 
 * and not access a cached copy. The application will stop, even on a multiprocessor-based or a 
 * multicore-based machine.
 */

/**
 * Use volatile only where visibility is an issue. Also, you can only use this reserved word in the context of field declarations 
 * (you'll receive an error if you try to make a local variable volatile). Finally, you can declare double and long fields volatile, 
 * but should avoid doing so on 32-bit JVMs because it takes two operations to access a double or long variable's value, 
 * and mutual exclusion (via synchronized) is required to access their values safely.
 */

