package com.chance;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class LifeDemo extends HttpServlet {  
      
    /** 
     * 构造方法 
     */  
    public LifeDemo() {  
        System.out.println("LifeDemo.LifeDemo()-->Servlet构造方法被调用了");  
    }  
      
    /** 
     * init方法 
     */  
    @Override  
    public void init() throws ServletException {  
        System.out.println("LifeDemo.init()-->init方法被调用了");  
    }  
      
    /** 
     * service方法被调用了 
     */  
    @Override  
    protected void service(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        System.out.println("LifeDemo.service()-->service方法被调用了");  
    }  
      
    /** 
     * destroy方法被调用了 
     */  
    public void destroy() {  
        System.out.println("LifeDemo.destroy()-->destroy方法被调用了");  
    }  
}  