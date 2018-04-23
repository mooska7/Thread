package com.klt.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 与MutexTread5例子同功效
 * @author abc
 *
 */
public class ConditionTread {
	public static void main(String[] args) {
		ConditionTread thread = new ConditionTread();
		final Bussiness bussieness = thread.new Bussiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 51; i++) {
					bussieness.sub(i);
				}

			}
		}).start();

		for (int i = 1; i < 51; i++) {
			bussieness.main(i);
		}

	}

	class Bussiness {
		private Lock lock = new ReentrantLock();
		private Condition condition = lock.newCondition();
		private boolean beShouldSub = true;
		public  void main(int loop) {
				lock.lock();
				while(beShouldSub){
					try {
						condition.await();
						beShouldSub = false;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (int i = 1; i < 51; i++) {
					System.out.println("Main thread sequence of " + i + " loop of " + loop);
				}
				beShouldSub = true;
				condition.signal();
				lock.unlock();
		}
		
		public void sub(int loop) {
				lock.lock();
				while(!beShouldSub){
					try {
						condition.await();
						beShouldSub = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (int i = 1; i < 11; i++) {
					System.out.println("Sub thread sequence of " + i + " loop of " + loop);
				}
				beShouldSub = false;
				condition.signal();
				lock.unlock();
			
		}
	}
}
