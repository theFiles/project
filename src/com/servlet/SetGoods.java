package com.servlet;

import cn.dao.GoodsInfoDao;
import cn.entity.GoodsInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class SetGoods extends LHttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int num = Integer.parseInt(req.getParameter("num"));
            // 取商品详情
            Map goods = GoodsInfoDao.getGoods(num);
            // 设置提交地址
            req.setAttribute("submitUrl","/index?c=SetGoods&num="+num);
            // 设置商品详情
            req.setAttribute("goodInfo",goods);
            jump("goodsInfo.jsp",req,resp);
            return;
        }
        catch (RuntimeException e){

        }
        jump("/index?c=GoodsList",resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int num = Integer.parseInt(req.getParameter("num"));
            GoodsInfo goodsInfo = new GoodsInfo();
            if(uploadSubmit("/image",req,goodsInfo)){
                GoodsInfoDao.setGoods(goodsInfo,num);
                jump("/index?c=GoodsList",resp);
                return;
            }
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        resp.getWriter().print("<script>alert('修改失败!');history.back();</script>");
    }
}
