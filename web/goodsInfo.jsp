<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16 0016
  Time: 下午 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/public.css">
</head>
<body>
<header class="nav">
    <h1 class="title">商品列表</h1>
    <ul>
        <li id="login-info" class="nav-li">${sessionScope.userInfo.user_name}
            <ul>
                <li><a href="/index?c=LoginOut">退出</a></li>
            </ul>
        </li>
        <li class="nav-li">商品操作
            <ul>
                <li><a href="/index?c=AddGoods">添加商品</a></li>
            </ul>
        </li>
    </ul>
</header>
<form action="${submitUrl}" method="post" enctype="multipart/form-data">
    <table>
        <tbody class="form-beautify">
            <tr>
                <td>商品名称：</td>
                <td>
                    <input class="form-node dashed-ipt" type="text" name="name">
                    <span class="err-msg"></span>
                </td>
            </tr>
            <tr>
                <td>商品价格：</td>
                <td>
                    <input class="form-node dashed-ipt" type="text" name="price">
                    <span class="err-msg"></span>
                </td>
            </tr>
            <tr>
                <td>库存：</td>
                <td>
                    <input class="form-node dashed-ipt" type="text" name="stock">
                    <span class="err-msg"></span>
                </td>
            </tr>
            <tr>
                <td>商品描述：</td>
                <td>
                    <input class="form-node dashed-ipt" type="text" name="description">
                    <span class="err-msg"></span>
                </td>
            </tr>
            <tr>
                <td>商品图片：</td>
                <td>
                    <input class="dashed-ipt" type="file" name="description">
                    <span class="err-msg"></span>
                </td>
            </tr>

        </tbody>
    </table>
    <input class="btn submit-btn" type="submit" value="提交">
    <input class="btn dashed-box" type="button" value="返回" onclick="location.href='/index?c=GoodsList'">
</form>
</body>
<script src="./js/public.js"></script>
<script src="./js/goodsInfo.js"></script>
</html>
