package com.klt.thread.mutex;

public class MutexTread6 {
	public static void main(String[] args) {
		MutexTread6 thread = new MutexTread6();
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
		private boolean beShouldSub = true;
		public synchronized void main(int loop) {
			if(beShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			for (int i = 1; i < 51; i++) {
				System.out.println("Main thread sequence of " + i + " loop of " + loop);
			}
			beShouldSub = true;
			this.notify();
		}
		
		public synchronized void sub(int loop) {
			if(!beShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for (int i = 1; i < 11; i++) {
				System.out.println("Sub thread sequence of " + i + " loop of " + loop);
			}
			beShouldSub = false;
			this.notify();
		}
	}
}
