package com.klt.innerclass.exercise;

public class InnerClassExercise {
	private int a;
	private static String b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	class Content{
//		private String content;
		
		public String getContent(){
			return "content";
		}
	}
	public Content getContent(){
		return new Content();
	}
	public static void main(String[] args) {
		InnerClassExercise demo = new InnerClassExercise();
		Content content1 = demo.getContent();
		InnerClassExercise.Content content2 = demo.new Content();
		InnerClassExercise.Content content3 = new InnerClassExercise().new Content();
		System.out.println(content1);
		System.out.println(content2);
		System.out.println(content3);
	}
}
