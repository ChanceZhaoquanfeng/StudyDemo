package com.chance.test;

public class CurrentUser1 {
	private static String id;
	private static String name;
	
	public static void main(String[] args) {
		CurrentUser1.setId("22");
		CurrentUser1.setName("33");
		System.out.println(CurrentUser1.id);
		System.out.println(CurrentUser1.name);
		
		CurrentUser1.setId("44");
		CurrentUser1.setName("55");
		System.out.println(CurrentUser1.id);
		System.out.println(CurrentUser1.name);
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		CurrentUser1.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		CurrentUser1.name = name;
	}
}
