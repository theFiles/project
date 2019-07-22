package com.servlet;

import cn.dao.GoodsInfoDao;
import cn.entity.GoodsInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class AddGoods extends LHttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("submitUrl","/index?c=AddGoods");
        jump("goodsInfo.jsp",req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GoodsInfo goodsInfo = new GoodsInfo();

        if(uploadSubmit("/image",req,goodsInfo)){
            try{
                goodsInfo.setFlag(1);
                GoodsInfoDao.addGoods(goodsInfo);
                jump("/index?c=GoodsList",resp);
                return;
            }
            catch (RuntimeException e){

            }
        }

        resp.getWriter().print("<script>alert('创建失败');history.back();</script>");
    }
}
