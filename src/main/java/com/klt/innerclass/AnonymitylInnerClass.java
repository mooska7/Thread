package com.klt.innerclass;

import com.klt.faced.PepoleSevice;
/**
 * 匿名内部类--->本质是没有定义但实现某接口的内部类
 * 第一：匿名内部类是没有访问修饰符的
 * 第二：new 匿名内部类，这个类首先是要存在的(即接口要存在)
 * 第三：匿名内部类中不能存在任何static变量和static方法，
 * 第四：匿名内部类可以访问外围类的任何属性和方法
 * 第五：匿名内部类是没有构造方法的。因为它连名字都没有何来构造方法
 * 			
 * 
 * @author mooska
 *
 */
public class AnonymitylInnerClass {
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
	
	public PepoleSevice getPepoleService(final int a){
		return new PepoleSevice() {
//			public static int b;
			
			@Override
			public void sing() {
				System.out.println("111"+name+race+a);
				hello();
			}
			
//			public static void sing2() {
//				System.out.println("111"+name+race+a);
//			}
		};
	}
	
	public dog getDog(){
		return new dog(){
			
		};
	}
	
	class dog {
		public PepoleSevice getPepoleService(){
			return new PepoleSevice() {
				
				@Override
				public void sing() {
					
				}
			};
		}
	}
	
	static class duck{
		public PepoleSevice getPepoleService(){
			return new PepoleSevice() {
				
				@Override
				public void sing() {
					
				}
			};
		}
	}
	
	public static void main(String[] args) {
		AnonymitylInnerClass demo = new AnonymitylInnerClass();
		demo.setName("mooska");
		demo.getPepoleService(2).sing();
	}
}
