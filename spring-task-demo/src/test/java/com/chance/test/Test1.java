package com.chance.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class Test1 {
	public static void main(String[] args) {
		List<A> copybefore=new ArrayList<A>();
		List<A> copyafter=new ArrayList<A>();
		A a=new A();
		a.setName("a");		
		A b=new A();
		b.setName("b");
		copybefore.add(a);
		copybefore.add(b);
		BeanUtils.copyProperties(copybefore, copyafter);
		
		copyafter.forEach((e)->System.out.println(e.getName()));
		
		
		String aa="qweqw/r/a";
		
	}
}
class A{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}