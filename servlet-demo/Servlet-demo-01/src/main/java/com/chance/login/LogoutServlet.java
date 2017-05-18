package com.chance.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		/**
		 * 安全退出：
		 * 	删除session对象中的登陆名username的属性即可
		 */
		//获取当前session
		HttpSession session = request.getSession(false);
		if(session != null){
			if(session.getAttribute("username") == null){
				response.getWriter().write("<html><body>您还尚未登陆，请先！<a href='" + request.getContextPath() + "/login.html'>登录</a></body></hmtl>");
				return;
			}
//			session.invalidate();//销毁session的对象
			session.removeAttribute("username");//移除登陆名username的属性即可！
			response.getWriter().write("<html><body>退出成功！<a href='" + request.getContextPath() + "/login.html'>登录</a></body></hmtl>");
		}else{
			response.getWriter().write("<html><body>您还尚未登陆，请先！<a href='" + request.getContextPath() + "/login.html'>登录</a></body></hmtl>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}