package com.klt.thread.mutex;

import com.klt.thread.mutex.pojo.Account;

public class MutexTread {
	public static void main(String[] args) {
		Account account = new Account("mooska", 6000);
		MutexTread thread = new MutexTread();
		final MutexTread.Outputer out = thread.new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
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
				while(true){
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
		//互斥的
//		public synchronized void output(String name) {
//			for (int i = 0; i < name.length(); i++) {
//				System.out.print(name.charAt(i));
//			}
//			System.out.println();
//		}
		
		//不互斥的
//		public  void output(String name) {
//			synchronized (name) {
//				for (int i = 0; i < name.length(); i++) {
//					System.out.print(name.charAt(i));
//				}
//				System.out.println();
//			}
//		}
		
		//互斥的
//		public  void output(String name) {
//			String temp = "";
//			synchronized (temp) {
//				for (int i = 0; i < name.length(); i++) {
//					System.out.print(name.charAt(i));
//				}
//				System.out.println();
//			}
//		}
		
		//互斥的
//		private String color = "dodo";
//		public  void output(String name) {
//			synchronized (color) {
//				for (int i = 0; i < name.length(); i++) {
//					System.out.print(name.charAt(i));
//				}
//				System.out.println();
//			}
//		}
		
		//互斥的
		public  void output(String name) {
			synchronized (this) {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}
}
