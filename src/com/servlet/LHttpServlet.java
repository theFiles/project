package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LHttpServlet extends HttpServlet {
    /**
     * 重定向
     */
    protected void jump(String name,HttpServletResponse resp) throws ServletException, IOException{
        resp.sendRedirect(name);
    }

    /**
     * 转发
     */
    protected void jump(String name,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(name).forward(req,resp);
    }

    /**
     * 打印
     */
}
