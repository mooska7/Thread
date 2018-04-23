package com.klt.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
//		ExecutorService es = Executors.newFixedThreadPool(3);//固定大小的线程池
//		ExecutorService es = Executors.newCachedThreadPool();//缓存线程池
		ExecutorService es = Executors.newSingleThreadExecutor();//单一线程池,但是如果意外死亡它会自动new一个新的线程
		for (int j = 1; j < 11; j++) {
			final int temp = j;
			es.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 1; i < 11; i++) {
						System.out.println(Thread.currentThread().getName() + " is looping of " + i + " for task of " + temp);
//						throw new NullPointerException("空了");
					}
				}
			});
		}
		
		
		System.out.println("all of 10 threads have submitted");
		es.shutdown();//等所有任务完成后结束线程池
//		es.shutdownNow();//不管任务有没有完成立即结束
	}
}
