package com.klt.thread.samphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadSamphore {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(3); 
		for(int i=1;i<11;i++){
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"进入,当前有"+(3-semaphore.availablePermits())+"并发");
					try {
						Thread.sleep((long) (Math.random()*10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"即将离开");
					semaphore.release();
					System.out.println(Thread.currentThread().getName()+"已离开,当前有"+(3-semaphore.availablePermits())+"并发");
				}
			};
			threadPool.execute(runnable);
		}
	}
}
