package com.chance.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class IndexServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		//获取session对象
		HttpSession session  = request.getSession(false);
		/**
		 * 1.在用户主页，判断session不为空且存在指定的属性才视为登陆成功！才能访问资源。
		 */
		//没有登陆成功，跳转到登陆界面
		if(session == null){
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		
		PrintWriter writer = response.getWriter();
		//取出会话数据
		String username = (String)session.getAttribute("username");
		/**
		 * 2.不存在指定的属性，没有登陆成功，跳转到登陆界面
		 */
		if(username == null){
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		String html = "";
		
		html += "<html><body>欢迎回来，" + username + "， <a href='/Servlet-demo-01/LogoutServlet'>安全退出</a></body></html>";
		
		
		writer.write(html);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
