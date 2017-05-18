package com.chance.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {
	
	public HelloFilter() {
		System.out.println("1.创建过滤器实例HelloFilter()");
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2.执行过滤器初始化方法init()");
	}
	/**
	 * 过滤器业务处理方法：在请求到达servlet之前先进入此方法进行公用的业务逻辑操作
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		System.out.println("3.执行过滤器业务处理方法doFilter()");
		
		//放行(到servlet)
		//如果有下一个过滤器，进入下一个过滤器，否则就执行访问servlet
		chain.doFilter(request, response);
		System.out.println("5.servlet处理完成，又回到过滤器");
	}
	
	public void destroy() {
		System.out.println("6.销毁过滤器实例");
	}
}