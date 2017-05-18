package com.chance;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.Enumeration;  
import javax.servlet.ServletException;  
import javax.servlet.ServletInputStream;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class RequestDemo3 extends HttpServlet {  
      
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        /* 
         * 设置参数查询的码表。该方法只能对实体内容的数据编码起作用。POST提交的数据在实体内容中，所以该方法对POST方式有效！ 
         * GET方式的参数放在URI后面，所以对GET方式无效！ 
         */  
        request.setCharacterEncoding("utf-8");  
          
        System.out.println(request.getMethod() + "方式提交的参数");  
    /*  //接收get方式提交的参数 
        String value = request.getQueryString(); 
        System.out.println(value);*/  
          
        /** 
         * 统一方便的获取请求参数的方法 
         */  
        //getParameter("参数名")：根据参数名得到参数值（只能获取一个值的参数值）  
        String userName = request.getParameter("userName");//iso-8859-1  
        /* 
         * 手动重新解码：iso-8859-1字符串-----》utf-8字符串 
         * 所以手动解码主要针对GET方式。POST方式可以使用request.setCharacterEncoding("utf-8");快速解决 
         */  
        if("GET".equals(request.getMethod())){  
            userName = new String(userName.getBytes("iso-8859-1"), "utf-8");  
        }  
        String password = request.getParameter("password");  
        System.out.println("userName=" + userName);  
        System.out.println("password=" + password);  
        System.out.println("========================================");  
        Enumeration<String> parameterNames = request.getParameterNames();  
        while(parameterNames.hasMoreElements()){  
            String parameterName = parameterNames.nextElement();  
            //  
            if("hobit".equals(parameterName)){  
                //getParameterValues("参数名"):根据参数名得到参数值（获取多个值的参数值）  
                String[] hobits = request.getParameterValues("hobit");  
                System.out.print("hobit=");  
                for(String hobit : hobits){  
                    if("GET".equals(request.getMethod())){  
                        hobit = new String(hobit.getBytes("iso-8859-1"), "utf-8");  
                    }  
                    System.out.print(hobit + "\t");  
                }  
                System.out.println();  
                continue;  
            }  
            String parametervalue = request.getParameter(parameterName);  
            if("GET".equals(request.getMethod())){  
                parametervalue = new String(parametervalue.getBytes("iso-8859-1"), "utf-8");  
            }  
            System.out.println(parameterName + "=" + parametervalue);  
        }  
    }  
      
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
    /*  System.out.println("POST方式提交的参数"); 
        ServletInputStream in = request.getInputStream(); 
        byte[] buff = new byte[1024]; 
        int len = 0; 
         
        while((len = in.read(buff)) != -1){ 
            System.out.println(new String(buff, 0, len)); 
        }*/  
          
        /** 
         * 统一方便的获取请求参数的方法 
         */  
/*      String userName = request.getParameter("userName"); 
        String password = request.getParameter("password"); 
        System.out.println("userName=" + userName); 
        System.out.println("password=" + password); 
        System.out.println("========================================"); 
        Enumeration<String> parameterNames = request.getParameterNames(); 
        while(parameterNames.hasMoreElements()){ 
            String element = parameterNames.nextElement(); 
            System.out.println(element + "=" + request.getParameter(element)); 
        }*/  
          
        this.doGet(request, response);  
    }  
      
}  