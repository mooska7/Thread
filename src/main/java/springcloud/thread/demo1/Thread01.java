package springcloud.thread.demo1;

public class Thread01 extends Thread{
	private String name;
	public Thread01(){
		
	}
	
	public Thread01(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("current thread "+name+" is run ...");
		}
	}
	
	public static void main(String[] args) throws Exception {
		Thread01 t1 = new Thread01("t1");
		Thread01 t2 = new Thread01("t2");
//		t2.setPriority(MAX_PRIORITY);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
