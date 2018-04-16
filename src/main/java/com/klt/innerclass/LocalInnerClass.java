package com.klt.innerclass;

import com.klt.faced.PepoleSevice;
/**
 * 局部内部类
 * 第一：局部内部类中不能存在任何static的变量和方法(成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类)
 * 第二：局部内部类可以访问外围类的任何属性和方法
 * 第三：局部内部类只能访问所在方法内的final变量
 * 第四：实例化成员内部类写法
 * 			外部类  demo = new 外部类();
 * 			外部类.内部类 innerClass = demo.new 内部类();
 * 
 * @author mooska
 *
 */
public class LocalInnerClass {
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
	
	public  String world(final String gender){
		final int  a = 0;
		class Cat implements PepoleSevice{
//			private static int x;
			@Override
			public void sing() {
				System.out.println("Cat is singing " + name+" "+gender+race +a);
				getSpecies();
				hello();
			}
//			public static void tree() {
////				System.out.println("Cat is singing " + name+" "+gender+race);
////				getSpecies();
//				hello();
//			}
			
			
		}
		new Cat().sing();
		return "get from outter class's method";
	}
	
	public static void main(String[] args) {
		LocalInnerClass demo = new LocalInnerClass();
		demo.setName("mooska");
		System.out.println(demo.world("男"));
	}
}
