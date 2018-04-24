package com.klt.thread.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadBlockArray {
	public static void main(String[] args) {
		final BlockingQueue bq = new ArrayBlockingQueue<String>(3);
		for(int i=1;i<4;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						try {
							Thread.sleep((long) (Math.random()*1000));
							System.out.println(Thread.currentThread().getName()+"准备放数据");
							bq.put("haha");
							System.out.println(Thread.currentThread().getName()+"已经放了一个数据,队列目前有"+bq.size()+"个数据");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}
			}).start();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep((long) (Math.random()*10000));
						System.out.println(Thread.currentThread().getName()+"准备取数据");
						Object ob = bq.take();
						System.out.println(Thread.currentThread().getName()+"已经取了一个数据"+ob+",队列目前有"+bq.size()+"个数据");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
}
