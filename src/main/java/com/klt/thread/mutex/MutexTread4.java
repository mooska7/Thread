package com.klt.thread.mutex;

public class MutexTread4 {
	public static void main(String[] args) {
		MutexTread4 thread = new MutexTread4();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 51; i++) {
					synchronized (MutexTread4.class) {
						for (int j = 1; j < 11; j++) {
							System.out.println("Sub thread sequence of " + j + " loop of " + i);
						}
					}
				}

			}
		}).start();

		for (int i = 1; i < 51; i++) {
			synchronized (MutexTread4.class) {
				for (int j = 1; j < 11; j++) {
					System.out.println("Main thread sequence of " + j + " loop of " + i);
				}
			}
		}

		// new Thread() {
		// @Override
		// public void run() {
		// for (int i = 1; i < 51; i++) {
		// for (int j = 1; j < 11; j++) {
		// System.out.println("Main thread sequence of " + j + " loop of "+i);
		// }
		// }
		// }
		// }.start();
	}

	static class Outputer {
		// 互斥的 字节码对象
		public synchronized static void output4(String name) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
