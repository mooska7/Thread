package com.klt.thread.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author abc
 *
 */
public class ThreadRWLock {
	public static void main(String[] args) {
		final ReadWrite rw = new ReadWrite();
		for(int i=1;i<11;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						rw.getData();
					}
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						rw.writeData(new Random().nextInt(10000));
					}
				}
			}).start();;
		}
	}
	
	
}

class ReadWrite{
	private int data = 0;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	public void getData(){
		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName()+" be ready to read data");
		try {
			Thread.sleep((long) (Math.random()*1000));
			System.out.println(Thread.currentThread().getName()+" have already read data : "+data);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();
		}
		
		
	}
	
	public void writeData(int data){
		lock.writeLock().lock();
		System.out.println(Thread.currentThread().getName()+" be ready to put data");
		try {
			Thread.sleep((long) (Math.random()*1000));
			this.data = data;
			System.out.println(Thread.currentThread().getName()+" have already put data : "+data);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}
	}
}
