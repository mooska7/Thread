package com.klt.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCyclicBarrier {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for(int i=0;i<3;i++){
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep((long) (Math.random()*10000));
						System.out.println(Thread.currentThread().getName()+"即将到达集合点1,当前已有"+(cb.getNumberWaiting()+1));
						cb.await();
						
						Thread.sleep((long) (Math.random()*10000));
						System.out.println(Thread.currentThread().getName()+"即将到达集合点2,当前已有"+(cb.getNumberWaiting()+1));
						cb.await();
						
						Thread.sleep((long) (Math.random()*10000));
						System.out.println(Thread.currentThread().getName()+"即将到达集合点3,当前已有"+(cb.getNumberWaiting()+1));
						cb.await();
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			};
			threadPool.execute(run);
		}
		
	}
}
