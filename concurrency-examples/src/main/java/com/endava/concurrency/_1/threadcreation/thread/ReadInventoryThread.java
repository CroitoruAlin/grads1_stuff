package com.endava.concurrency._1.threadcreation.thread;

public class ReadInventoryThread extends Thread {
	public void run() {
		System.out.println("Printing zoo inventory");
	}

	public static void main(String[] args) {
		// single thread creation
		Thread worker = new ReadInventoryThread();
		worker.start();
	}
}
