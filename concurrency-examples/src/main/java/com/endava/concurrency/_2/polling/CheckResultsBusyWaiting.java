package com.endava.concurrency._2.polling;

public class CheckResultsBusyWaiting {
	// counter is not thread safe
	static int counter = 0;

	public static void main(final String[] args) {
		// Runnable
		new Thread(new BusyWaitingCounter()).start();
		// busy waiting -> bad coding practice
		// No guarantee when the loop will terminate (if)
		while (CheckResultsBusyWaiting.counter < 5000000) {
			System.out.println("Not reached yet");
		}
		System.out.println("Reached!");
	}
}

class BusyWaitingCounter implements Runnable {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		for (int i = 0; i < 5000000; i++) {
			CheckResultsBusyWaiting.counter++;
		}
	}

}