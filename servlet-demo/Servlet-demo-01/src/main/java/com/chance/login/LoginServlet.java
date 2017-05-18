package com.chance.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
* Author：Liu Zhiyong（QQ：1012421396）
* Version：Version_1
* Date：2016年12月4日13:23:26
* Desc：Session会话登陆案例
*/
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*
		 * 获取提交的参数
		 */
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		if("木丁西".equals(username) && "666666".equals(pwd)){//登陆成功
			/*
			 * 将用户名存入session域对象
			 */
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect(request.getContextPath() + "/IndexServlet");
		}else{//登陆失败
			response.sendRedirect(request.getContextPath() + "/fail.html");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}