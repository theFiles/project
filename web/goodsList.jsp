<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16 0016
  Time: 下午 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/public.css">
    <link rel="stylesheet" href="./css/goods.css">
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
    <div class="goods-body">
        <c:forEach items="${goodsList}" var="goods">
            <div class="goods-info dashed-box">
                <b>&times;</b>
                <a href="/index?c=SetGoods&num=${goods.id}">
                    <div class="goods-img">
                        <img src="./image/${goods.goods_pic}" alt="">
                    </div>
                    <span>${goods.goods_name}</span>
                </a>
            </div>
        </c:forEach>
    </div>
</body>
<script src="./js/public.js"></script>
</html>
