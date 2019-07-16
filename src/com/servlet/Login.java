package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import com.servlet.mysql.Users;

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
            user != null && !"".equals(user)
            && pwd != null && !"".equals(pwd)
        ){
            try {

                Map res = Users.login(user,pwd);

                if(res != null){
                    req.getSession().setAttribute("userInfo",res);

                    jump("/index?c=GoodsList",resp);
                    return;
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }

        String errMsg = java.net.URLEncoder.encode("用户密码有误！","UTF-8");
        jump("/index?c=Login&errMsg="+errMsg,resp);
    }
}
