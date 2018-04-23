package com.klt.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 与MutexTread5例子同功效
 * @author abc
 *
 */
public class ConditionTread2 {
	public static void main(String[] args) {
		ConditionTread2 thread = new ConditionTread2();
		final Bussiness bussieness = thread.new Bussiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 51; i++) {
					bussieness.sub(i);
				}

			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 51; i++) {
					bussieness.sub_2(i);
				}

			}
		}).start();
		
		
		for (int i = 1; i < 51; i++) {
			bussieness.sub_3(i);
		}

	}

	class Bussiness {
		private Lock lock = new ReentrantLock();
		private Condition condition_1 = lock.newCondition();
		private Condition condition_2 = lock.newCondition();
		private Condition condition_3 = lock.newCondition();
		private int x = 1;
		
		
		public void sub(int loop) {
				lock.lock();
				while(x!=1){
					try {
						condition_1.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (int i = 1; i < 11; i++) {
					System.out.println("Sub_1 thread sequence of " + i + " loop of " + loop);
				}
				x = 2;
				condition_2.signal();
				lock.unlock();
			
		}
		
		public void sub_2(int loop) {
			lock.lock();
			while(x!=2){
				try {
					condition_2.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i < 11; i++) {
				System.out.println("Sub_2 thread sequence of " + i + " loop of " + loop);
			}
			x = 3;
			condition_3.signal();
			lock.unlock();
		
		}
		
		public void sub_3(int loop) {
			lock.lock();
			while(x!=3){
				try {
					condition_3.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i < 11; i++) {
				System.out.println("Sub_3 thread sequence of " + i + " loop of " + loop);
			}
			x = 1;
			condition_1.signal();
			lock.unlock();
		
		}
	}
}
