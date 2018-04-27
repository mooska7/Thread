package com.klt.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionThread {
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(10);
		
//		System.out.println("拿到结果:"+future.get());
		
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(es);
		for(int i=1;i<11;i++){
			final int temp = i;
			completionService.submit(new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					Thread.sleep(5000);
					return temp;
				}
			});
		}
		
		for(int i=1;i<11;i++){
			System.out.println(completionService.take().get());
		}
		
		es.shutdown();
		
		
	}
}
