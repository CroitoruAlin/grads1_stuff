package com.endava.concurrency._3.threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSingleThread {

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			service.execute(new PrintInput("Printing zoo inventory"));
			service.execute(new PrintRecords());
			service.execute(new PrintInput("Printing zoo inventory"));
			System.out.println("end");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
	
	static class PrintInput implements Runnable {
		private String str;
		public PrintInput (String str) {
			this.str = str;
		}
		
		public void run() {
			System.out.println(str);
		}
	}
	
	static class PrintRecords implements Runnable {
		
		public void run() {
			System.out.println("records");
		}
	}
	

}
