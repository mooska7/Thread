package com.klt.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时计数器
 * @author abc
 *
 */
public class ThreadCountDownLatch {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1);
		final CountDownLatch cdAnswer = new CountDownLatch(3);
		for(int i=0;i<3;i++){
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep((long) (Math.random()*10000));
						System.out.println(Thread.currentThread().getName()+"正准备接爱命令");
						cdOrder.await();
						
						System.out.println(Thread.currentThread().getName()+"已接受命令");
						Thread.sleep((long) (Math.random()*10000));
						
						System.out.println(Thread.currentThread().getName()+"回应命令处理结果");
						cdAnswer.countDown();
//						System.out.println("countDown"+cdAnswer.getCount());
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			};
			threadPool.execute(run);
		}
		try {
			Thread.sleep((long) (Math.random()*10000));
			System.out.println(Thread.currentThread().getName()+"即将发布命令");
			cdOrder.countDown();
			System.out.println(Thread.currentThread().getName()+"已发布命令");
			cdAnswer.await();
			System.out.println(Thread.currentThread().getName()+"已收到所有响应结果");
		} catch (Exception e) {
			e.printStackTrace();
		}
		threadPool.shutdown();
	}
}
