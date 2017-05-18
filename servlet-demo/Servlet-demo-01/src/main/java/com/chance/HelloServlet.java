package com.chance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * servletDemo 
 * 重写doget dopost方法
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
	/**
	 * HttpServletRequest 网页发过来的请求
	 * HttpServletResponse 返回给网页的响应
	 */
	 /** 
     * 1.tomcat服务器接收到浏览器发送的请求数据，然后封装到HttpServletRequest对象中 
     * 2.tomcat服务器调用doGet方法，然后request对象传入到servlet中 
     */  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置输出格式，解决中文乱码问题
				response.setContentType("text/html; charset=utf-8");
				// 获取输出流对象
				PrintWriter out = response.getWriter();
				// 向浏览器输出内容
				out.write("这是我的第一个Servlet代码");
				
		/* 
         * 3.从request对象中取出请求数据 
         */  
        /* 
         * 3.1请求行 
         */  
        //请求方式 
        System.out.println("----------------------请求行  ---------------------");
        System.out.println("请求方式-->" + request.getMethod());  
        //请求资源  
        System.out.println("URI-->" + request.getRequestURI());  
        System.out.println("URL-->" + request.getRequestURL());  
        //http协议  
        System.out.println("http协议版本-->" + request.getProtocol());  
        /* 
         * 3.2请求头 
         */
        System.out.println("----------------------请求头---------------------");
        //得到referer头
  		String referer = request.getHeader("referer");
  		System.out.println("referer="+referer);
  		/**
		 * 判断非法链接：
		 * 	1）直接访问的话referer=null
		 *  2）如果当前请求不是来自广告   
		 */
		if(referer==null || !referer.contains("/web161115/ad.html")){
			response.getWriter().write("当前是非法链接，请回到首页。<a href='/web161115/ad.html'>首页</a>");
		}else{
			//正确的链接
			response.getWriter().write("资源正在下载...");
		}
		
        Enumeration<String> enumeration = request.getHeaderNames();  
        while(enumeration.hasMoreElements()){  
             String data = enumeration.nextElement();  
                System.out.println(data + ":" + request.getHeader(data));  
        }  
        /* 
         * 3.3请求 的实体内容 
         */  
        System.out.println("----------------------请求 的实体内容 ---------------------");
        ServletInputStream in = request.getInputStream();  
        byte[] buff = new byte[1024];  
        int len = 0;  
        while((len = in.read(buff)) != -1){  
            String str = new String(buff, 0, len);  
            System.out.println(str);  
        }  
        out.flush();
		out.close();
		
	}

}
