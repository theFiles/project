package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 入口文件
 */
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nextServlet(req,resp,"doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nextServlet(req,resp,"doPost");
}

    private void nextServlet(HttpServletRequest req, HttpServletResponse resp,String method) throws ServletException, IOException {
        String c = req.getParameter("c");

        // 是否传入c参数
        if(c != null && !"".equals(c)){
            // 拼接 servlet 对象
            try {
                // servlet取对象实例
                Class nextServlet = Class.forName("com.servlet." + c);
                // 转交请求
                nextServlet.getMethod(method, HttpServletRequest.class, HttpServletResponse.class).invoke(nextServlet.newInstance(),req,resp);
                return;

            } catch (
                    ClassNotFoundException
                            | IllegalAccessException
                            | InvocationTargetException
                            | InstantiationException
                            | NoSuchMethodException e
                    ) {
                e.printStackTrace();
            }
        }

        req.getRequestDispatcher("404.html").forward(req,resp);
    }
}
