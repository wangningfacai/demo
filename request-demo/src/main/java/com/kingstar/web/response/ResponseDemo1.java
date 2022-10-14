package com.kingstar.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("resp1...");
//        //设置相应状态码
//        response.setStatus(302);
//        //设置相应头Location
//        response.setHeader("location","/web-demo/resp2");//重定向需要加上虚拟目录

        //简化方式重定向
//        response.sendRedirect("/web-demo/resp2");
//        response.sendRedirect("http://www.baidu.com");//可重定向到任意位置资源
        //重定向动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }
}
