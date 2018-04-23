package com.klt.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadCallable {
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> future = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(10000);
				return "haah";
			}
		});
//		System.out.println("拿到结果:"+future.get());
		System.out.println("拿到结果:"+future.get(2, TimeUnit.SECONDS));
		
	}
}
