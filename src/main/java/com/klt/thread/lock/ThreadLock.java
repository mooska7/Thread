package com.klt.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock {
	public static void main(String[] args) {
		ThreadLock thread = new ThreadLock();
		final ThreadLock.Outputer out = thread.new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
						out.output("mooska");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
						out.output("tiantian");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	class Outputer {
		Lock lock = new ReentrantLock();
		public void output(String name) {
			try {
				lock.lock();
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
		}
	}
}
