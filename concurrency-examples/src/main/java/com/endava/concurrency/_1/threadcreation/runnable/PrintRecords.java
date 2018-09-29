package com.endava.concurrency._1.threadcreation.runnable;

public class PrintRecords implements Runnable {
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Printing record: " + i);
		}
	}

	public static void main(String[] args) {
		// single thread creation
		Thread worker = new Thread(new PrintRecords());
		worker.start();
	}
}