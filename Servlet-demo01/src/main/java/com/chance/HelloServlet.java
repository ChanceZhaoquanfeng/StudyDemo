package com.chance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * servletDemo 
 * 
 * @author chance
 *
 */
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);// 调用doGet()
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置输出格式，解决中文乱码问题
		response.setContentType("text/html; charset=utf-8");
		// 获取输出流对象
		PrintWriter out = response.getWriter();
		// 向浏览器输出内容
		out.write("这是我的第一个Servlet代码");
		out.flush();
		out.close();
	}

}
