package com.kingstar.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo",loadOnStartup = 1)
public class ServletDemo implements Servlet {

    /**
     * 初始化方法：
     * 1.调用时机：默认情况下，Servlet首次被访问时就创建对象，对象会调用init方法
     *  也可通过修改属性修改调用时机：loadOnStartup为负数时，则会在创建对象的时候调用
     *                          loadOnStartup为0或者正整数时，则会在服务启动时调用
     *                          loadOnStartup默认 = -1
     * 2.调用次数：1次，多次刷新，只会调用service方法，不会再调用init方法
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 提供服务
     * 1.调用时机：每次servlet被访问时
     * 2.调用次数：多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello~~~");
    }

    /**
     * 销毁方法：
     * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁时调用
     * 2.调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destroy~~~");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
