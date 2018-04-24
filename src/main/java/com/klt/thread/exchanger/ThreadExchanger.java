package com.klt.thread.exchanger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExchanger {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger<String>();
		Runnable run = new Runnable() {
			@Override
			public void run() {
				try {
					String data1 = "mooska";
					System.out.println(Thread.currentThread().getName() + "正在把数据" + data1 + "交换出去");
					Thread.sleep((long) (Math.random() * 10000));
					String data2 = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName() + "换回的数据为" + data2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		threadPool.execute(run);

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				try {
					String data1 = "Ever";
					System.out.println(Thread.currentThread().getName() + "正在把数据" + data1 + "交换出去");
					Thread.sleep((long) (Math.random() * 10000));
					String data2 = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName() + "换回的数据为" + data2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		threadPool.execute(run2);

		threadPool.shutdown();
	}
}
