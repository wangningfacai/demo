package com.kingstar.web;

import com.kingstar.pojo.Brand;
import com.kingstar.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用brandService完成查询
//        BrandService brandService = new BrandService();
        List<Brand> brands = brandService.selectAll();

        //2.存入request域中
        request.setAttribute("brands",brands);

        //3.转发到的brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
