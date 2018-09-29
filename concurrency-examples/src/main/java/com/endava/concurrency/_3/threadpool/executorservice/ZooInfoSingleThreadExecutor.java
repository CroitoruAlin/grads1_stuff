package com.endava.concurrency._3.threadpool.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.endava.concurrency._1.threadcreation.runnable.PrintInput;
import com.endava.concurrency._1.threadcreation.runnable.PrintRecords;

public class ZooInfoSingleThreadExecutor {
	public static void main(final String[] args) {
		ExecutorService service = null;
		ExecutorService service2 = null;
		try {
			service = Executors.newSingleThreadExecutor();
			service.execute(new PrintInput("begin"));
			service.execute(new PrintInput("Printing zoo inventory"));

			service2 = Executors.newSingleThreadExecutor();
			service2.execute(new PrintInput("2 begin"));
			service2.execute(new PrintInput("2 Printing zoo inventory"));
			service2.execute(new PrintRecords());

			service.execute(new PrintRecords());
			service.execute(new PrintInput("1 Printing zoo inventory"));
			service.execute(new PrintInput("1 end"));
		} finally {
			if (service != null) {
				service.shutdown();
			}
			if (service2 != null) {
				service2.shutdown();
			}
		}
		System.out.println("Main end!");
	}
}
