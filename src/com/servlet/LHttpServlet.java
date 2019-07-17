package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract class LHttpServlet extends HttpServlet {
    abstract public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    abstract public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    /**
     * 重定向
     */
    protected void jump(String uri,HttpServletResponse resp) throws ServletException, IOException{
        resp.sendRedirect(uri);
    }

    /**
     * 转发
     */
    protected void jump(String uri,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(uri).forward(req,resp);
    }

    /**
     * 打印
     */
    protected  void print(String content){

    }

}
