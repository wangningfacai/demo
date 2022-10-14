package com.kingstar.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字符数据的响应体
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");//既可以设置contType信息，也可以字符集，避免乱码
        //获取字符输出流
        // 流不需要关闭,随着响应结束，response对象销毁，由服务器关闭
        PrintWriter writer = response.getWriter();
        writer.write("王宁");//写数据
        writer.write("<h1>aaa</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }
}
