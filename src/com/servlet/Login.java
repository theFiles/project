package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.lmysql.Mysql;

public class Login extends LHttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jump("login.jsp",req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        if(
            user != null && "".equals(user)
            && pwd != null && "".equals(pwd)
        ){
            Mysql mysql = new Mysql();
            List res = mysql.select()
                 .where("id",1)
                 .query("users");

            resp.getWriter().println(res.size());

        }
    }
}
