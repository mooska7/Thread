package com.klt.innerclass;
/**
 * 成员内部类
 * 第一：成员内部类中不能存在任何static的变量和方法(成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类)
 * 第二：成员内部类可以访问外围类的任何属性和方法
 * 第三：实例化成员内部类写法
 * 			外部类  demo = new 外部类();
 * 			外部类.内部类 innerClass = demo.new 内部类();
 * 
 * @author mooska
 *
 */
public class InnerClassDemo02 {
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

	class InnerClass{
		private String name;
		private int grade;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		public void say(){
			System.out.println("I'm a inner class, my name is " + name+","+species+","+race+","+gender+","+age+","+grade);
			System.out.println("I'm a inner class, my name is " + name+","+species+","+race+","+gender+","+age+","+grade+" "+hello()+" "+world());
		}
	}
	
	
	public static void main(String[] args) {
		InnerClassDemo02 demo = new InnerClassDemo02();
		demo.setName("张飞");
		demo.setAge(1800);
		demo.setGender("男");
		demo.race = "非洲";		
		InnerClassDemo02.InnerClass innerClass = demo.new InnerClass();
		innerClass.setGrade(4);
		innerClass.say();
		
	}
}
