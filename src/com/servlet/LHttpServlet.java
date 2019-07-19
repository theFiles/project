package com.servlet;

import module.ljson.ILJson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

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

    protected  boolean uploadSubmit(String path, HttpServletRequest req, ILJson obj) throws IOException {
        // 是否上传文件表单(ServletFileUpload包)
        if(ServletFileUpload.isMultipartContent(req)){


            try {
                // 取 ServletFileUpload 对象
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                // 把参数转换成上传文件格式
                List<FileItem> fileItems = upload.parseRequest(req);

                // 不为空
                if(fileItems != null && fileItems.size() > 0){
                    for(FileItem f:fileItems){

                        // 是普通表单
                        if(f.isFormField()){
                            obj.set(f.getFieldName(),f.getString("utf-8"));
                        }
                        // 上传文件空间
                        else{
//                            System.out.println(f.isInMemory());
//                            System.out.println(f.getSize());
                            // 取文件名
                            String fileName = f.getName();

                            // 获取文件上传路径
                            String parentPath = req.getServletContext().getRealPath(path);

                            // 取文件对象
                            File dir = new File(parentPath);
                            // 目录不存在则创建
                            if(!dir.exists()) dir.mkdirs();

                            // 重新取文件对象
                            File file = new File(dir,fileName);

                            // 取控件对象的输入流
                            InputStream inputStream = f.getInputStream();
                            // 取文件对象的输出流
                            OutputStream outputStream = new FileOutputStream(file);

                            // 通过(IO包复制文件)
                            IOUtils.copy(inputStream,outputStream);

                            // 关闭流
                            outputStream.close();
                            inputStream.close();

                            // 把文件名存到对象里
                            obj.set(f.getFieldName(),fileName);

                        }
                    }

                    return true;
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }

        return false;
    }

}
