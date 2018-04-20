package com.klt.thread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 线程满了围内的数据共享
 * @author abc
 *
 */
public class ThreadScopeShareData2 {
	private static int data = 0;
	private static AtomicInteger atomicInteger = new AtomicInteger();
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					threadLocal.set(atomicInteger.incrementAndGet());
					System.out.println(Thread.currentThread().getName()+" has put data : "+threadLocal.get());
					new A().getData();
					new B().getData();
				}
			}).start();
		}
	}
	
	static class A{
		public int getData(){
			System.out.println("A from " + Thread.currentThread().getName()+" get data : "+threadLocal.get());
			return data;
		}
	}
	
	static class B{
		public int getData(){
			System.out.println("B from " + Thread.currentThread().getName()+" get data : "+threadLocal.get());
			return data;
		}
	}
	
}
