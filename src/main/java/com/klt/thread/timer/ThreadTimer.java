package com.klt.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class ThreadTimer {
	private static int count = 0;
	public static void main(String[] args) {
		//隔多少毫秒后炸
//		new Timer().schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("bombing after 1S and only once...");
//				
//			}
//		}, 1000);
		//隔多少毫秒后执行，并且每几秒后执行一次
//		new Timer().schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("bombing after 5S and then bombing in every 3S... Date:"+new Date());
//				
//			}
//		}, 5000,3000);
		//2S后炸一个,接着4S后炸一个,依次循环下去(子母炸弹)
		System.out.println(new Date());
		class MyTimerTask extends TimerTask{
			@Override
			public void run() {
				count = (count+1)%2;
				System.out.println("bombing... Date:"+new Date());
				new Timer().schedule(new MyTimerTask(),2000*(1+count));
			}
			
		}
		new Timer().schedule(new MyTimerTask(), 2000);
		while (true) {
			try {
				System.out.println(new Date().getSeconds());
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
