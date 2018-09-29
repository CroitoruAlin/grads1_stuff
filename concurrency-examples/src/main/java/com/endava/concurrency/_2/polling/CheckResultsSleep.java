package com.endava.concurrency._2.polling;

public class CheckResultsSleep {
	// counter is not thread safe
	static int counter = 0;

	public static void main(final String[] args) throws InterruptedException {
		// Runnable
		new Thread(new SleepCounter()).start();
		// no busy waiting -> sleep does not occupy CPU time continuously
		while (CheckResultsSleep.counter < 5000000) {
			System.out.println("Not reached yet");
			Thread.sleep(1000); // 1 SECOND
		}
		System.out.println("Reached!");
	}
}

class SleepCounter implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5000000; i++) {
			CheckResultsSleep.counter++;
		}
	}
}