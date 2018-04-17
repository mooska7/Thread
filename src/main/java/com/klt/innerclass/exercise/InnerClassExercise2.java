package com.klt.innerclass.exercise;

import java.util.ArrayList;
import java.util.List;

public class InnerClassExercise2 {
	private List<Content> contents;
	
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	class Content{
		private String content;
		
		public void setContent(String content) {
			this.content = content;
		}

		public String getContent(){
			return content;
		}
	}
	public Content getContent(){
		return new Content();
	}
	public static void main(String[] args) {
		InnerClassExercise2 demo = new InnerClassExercise2();
		Content content1 = demo.getContent();
		InnerClassExercise2.Content content2 = demo.new Content();
		InnerClassExercise2.Content content3 = new InnerClassExercise2().new Content();
		List<Content> list = new ArrayList<Content>();
		list.add(content1);
		list.add(content3);
		list.add(content2);
		demo.setContents(list);
		for(Content co:demo.getContents()){
			System.out.println(co.getContent()==null);
		}
	}
}
