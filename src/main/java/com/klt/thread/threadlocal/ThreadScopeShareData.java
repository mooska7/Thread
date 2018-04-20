package com.klt.thread.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 线程满了围内的数据共享
 * @author abc
 *
 */
public class ThreadScopeShareData {
	private static int data = 0;
	private static AtomicInteger atomicInteger = new AtomicInteger();
	private static Map<String,Integer> dataMap = new HashMap<String,Integer>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					dataMap.put(Thread.currentThread().getName(), atomicInteger.incrementAndGet());
					System.out.println(Thread.currentThread().getName()+" has put data : "+dataMap.get(Thread.currentThread().getName()));
					new A().getData();
					new B().getData();
				}
			}).start();
		}
	}
	
	static class A{
		public int getData(){
			System.out.println("A from " + Thread.currentThread().getName()+" get data : "+dataMap.get(Thread.currentThread().getName()));
			return data;
		}
	}
	
	static class B{
		public int getData(){
			System.out.println("B from " + Thread.currentThread().getName()+" get data : "+dataMap.get(Thread.currentThread().getName()));
			return data;
		}
	}
	
}
