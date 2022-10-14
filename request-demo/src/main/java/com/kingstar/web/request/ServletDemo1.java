package com.kingstar.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * 解决中文乱码问题
 */
@WebServlet("/req")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //post请求 getReader()获取数据乱码,设置字符输入流编码
//        request.setCharacterEncoding("UTF-8");

        //获取用户名
        String username = request.getParameter("username");
        System.out.println("解决乱码前：" + username);

        //get请求，解决乱码问题
        //get获取参数方式：getQueryString
        //乱码原因：tomcat进行URL界面，默认字符集ISO-8859-1
        //1.先对乱码数据进行编码：转为字节数组
        //byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        //2.将字节解码
        //username = new  String(bytes,StandardCharsets.UTF_8);
        username = new  String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);//get和post乱码通用解决方式
        System.out.println("解决乱码后：" + username);
        //tomcat8.0之后，已将get请求乱码问题解决，设置默认的解码方式为UTF-8

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        this.doGet(request,response);
    }
}
