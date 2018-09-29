package com.endava.concurrency._3.threadpool.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSum {

	public static void main(String[] args) {

		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			Future<?> future = service.submit(new CallableInternalSum(15, 2));
	
			System.out.println("end");
			
			// you can comment the below section try{} catch and see if the future is still done, usually not
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			System.out.println("future.isDone(): " + future.isDone());
			System.out.println("future.get(): " + future.get().toString());

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (service != null)
				service.shutdown();
		}
		
		
	}
	
	
	static class CallableInternalSum implements Callable<Integer> {
		int value1; int value2;

		CallableInternalSum(int value1, int value2) {
	  	    this.value1 = value1;
		    this.value2 = value2;
		}

		@Override
		public Integer call() throws Exception {
		    return value1 + value2;
	    	}
	    }


}
