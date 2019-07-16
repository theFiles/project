package com.servlet;

import com.servlet.mysql.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Registered extends LHttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jump("registered.jsp",req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap<>();
        map.put("user_name",req.getParameter("user"));
        map.put("user_pwd",req.getParameter("pwd"));
        map.put("sex",req.getParameter("sex"));
        map.put("email",req.getParameter("email"));
        map.put("hobbys",req.getParameter("hobbys"));
        map.put("address",req.getParameter("address"));
        map.put("phone",req.getParameter("phone"));

        int insertId = Users.addUser(map);
        if(insertId > 0){
            // 存入id
            map.put("id",insertId);
            // 写入session
            req.getSession().setAttribute("userInfo",map);

            // 跳到商品页面
            jump("/index?c=GoodsList",resp);
        }
    }
}
