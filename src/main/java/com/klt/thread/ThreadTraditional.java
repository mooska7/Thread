package com.klt.thread;

/**
 * 线程
 * @author abc
 *
 */
public class ThreadTraditional {
	public static void main(String[] args) {
		//新建子类线程
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500000l);
						System.out.println(Thread.currentThread().getName());
						System.out.println(this.getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		};
		thread.start();
		
		//线程绑定对象
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500l);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		});
		thread2.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500l);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500l);
						System.out.println("子:"+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		}.start();
	}
}
