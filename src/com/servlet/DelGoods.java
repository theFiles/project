package com.servlet;

import cn.dao.GoodsInfoDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelGoods extends LHttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("???");
        String id = req.getParameter("num");
        if(id != null && !"".equals(id)){
            try{
                int res = GoodsInfoDao.delGoods(Integer.parseInt(id));

                if(res > 0){
                    jump("/index?c=GoodsList",resp);
                    return;
                }

            }
            catch (RuntimeException e){

            }
        }

        resp.getWriter().print("<script>alert('删除失败！');history.back();</script>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
