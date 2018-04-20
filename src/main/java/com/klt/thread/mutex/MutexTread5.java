package com.klt.thread.mutex;

public class MutexTread5 {
	public static void main(String[] args) {
		MutexTread5 thread = new MutexTread5();
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
			synchronized(this){
				while(beShouldSub){
					try {
						this.wait();
						beShouldSub = false;
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
		}
		
		public void sub(int loop) {
			synchronized(this){
				while(!beShouldSub){
					try {
						this.wait();
						beShouldSub = true;
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
}
