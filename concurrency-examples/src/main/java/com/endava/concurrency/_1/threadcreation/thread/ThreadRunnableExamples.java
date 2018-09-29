package com.endava.concurrency._1.threadcreation.thread;

import com.endava.concurrency._1.threadcreation.runnable.PrintRecords;
import com.endava.concurrency._1.threadcreation.thread.ReadInventoryThread;

public class ThreadRunnableExamples {

	public static void main(String[] args) {
		System.out.println("begin");
		Thread worker1 = new ReadInventoryThread();
		Thread worker2 = new Thread(new PrintRecords());
		Thread worker3 = new ReadInventoryThread();
		Thread worker4 = new Thread(new PrintRecords());
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
            worker4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
	}
}
