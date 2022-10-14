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

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

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
        User u = mapper.selectByUsername(username);


        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        //判断u是否为null
        if(u == null){
            //用户不存在，可以注册
            mapper.addUser(user);
            sqlSession.commit();
            //2.5 释放资源
            sqlSession.close();
            writer.write("注册成功");
        }else {
            //用户已存在，注册失败
            writer.write("用户已存在");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }

}
