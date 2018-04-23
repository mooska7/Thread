package com.klt.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
//		es.schedule(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("bombing...");
//				
//			}
//		}, 2, TimeUnit.SECONDS);
		
		es.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing...");
				
			}
		}, 2,6, TimeUnit.SECONDS);
	}
}
