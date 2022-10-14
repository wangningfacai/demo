package com.kingstar.web;

import com.kingstar.Utils.SqlSessionFactoryUtils;
import com.kingstar.mapper.UserMapper;
import com.kingstar.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用MyBatis完成查询
//        //2.1 获取sqlSessionFactory对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.2 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //2.4 调用方法
        User user = mapper.select(username,password);
        //2.5 释放资源
        sqlSession.close();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        //判断user是否为null
        if(user != null){
            //登录成功
            writer.write("登录成功");
        }else {
            //登录失败
            writer.write("登录失败");
        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }

}
