package springcloud.thread.demo1;

public class Thread02 implements Runnable{
	private String name;
	public Thread02(){
		
	}
	
	public Thread02(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(1111);
	}
	
	public synchronized void sayHello(){
		System.out.println("hello world");
	}
	
	public static void main(String[] args) {
		Thread01 t1 = new Thread01("t1");
		Thread01 t2 = new Thread01("t2");
//		Thread
	}

}
