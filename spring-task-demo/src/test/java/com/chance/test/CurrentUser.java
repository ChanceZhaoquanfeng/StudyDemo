package com.chance.test;


/**
 * 
 * 单例模式<br>
 * 全局当前用户对象<br>
 * 
 * @author chance.zhao
 *
 */
public class CurrentUser {
	
	//当前用户的ID
	private String id;
	//当前用户的名字
	private String name;
	
	//获取当前的实例对象
	public static CurrentUser getCurrentUser(){
		return CurrentUserClass.user;
	}
	
	private static class CurrentUserClass{
		private static final CurrentUser user=new CurrentUser();
	}
	
	
	public CurrentUser(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
