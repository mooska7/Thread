package com.klt.innerclass;

import com.klt.faced.PepoleSevice;

/**
 * 静态成员内部类
 * 第一：静态成员内部类中可以存在static的变量和static的方法(静态成员内部类不依附于外围类)
 * 第二：静态成员内部类只能访问外围类的静态属性和静态方法
 * 第三：静态成员内部类使用
 * 			外部类.内部类 staticInnerClass = new 外部类.内部类();
 * 			staticInnerClass.非静态方法();
 * 		或者
 * 			静部类.静态方法();
 * @author mooska
 *
 */
public class StaticInnerClassDemo {
	private String name;
	private String gender;
	private Integer age;
	private static String race;
	private final String species = "Human";
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}
	
	public static String hello(){
		return "get from outter class's static method";
	}
	
	public  String world(){
		return "get from outter class's method";
	}

	static class StaticInnerClass implements PepoleSevice{
		private static int x;
		public void say(){
//			System.out.println("I'm a inner class, my name is " + name+","+species+","+race+","+gender+","+age+","+grade);
			System.out.println(hello());//能访问静态方法 
//			System.out.println(world());//不能访问非静态方法
			System.out.println(race);//能访问静态属性 
//			System.out.println(name);//不能访问静态属性 
		}
		
		public static void cry(){
//			System.out.println("I'm a inner class, my name is " + name+","+species+","+race+","+gender+","+age+","+grade);
			System.out.println(hello());//能访问静态方法 
//			System.out.println(world());//不能访问非静态方法
			System.out.println(race);//能访问静态属性 
//			System.out.println(name);//不能访问静态属性 
		}

		@Override
		public void sing() {
			System.out.println("静态成员内部类在唱歌");
			
		}
	}
	
	
	public static void main(String[] args) {
//		StaticInnerClassDemo demo = new StaticInnerClassDemo();
//		StaticInnerClassDemo.new StaticInnerClass().say();
		StaticInnerClassDemo.StaticInnerClass staticInnerClass = new StaticInnerClassDemo.StaticInnerClass();
		staticInnerClass.say();
		staticInnerClass.sing();
		StaticInnerClass.cry();
	}
}
