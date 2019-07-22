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
    <link rel="stylesheet" href="./css/goods.css">
</head>
<body>
    <%@ include file="header.jsp"%>
    <div class="goods-body">
        <c:forEach items="${goodsList}" var="goods">
            <div class="goods-info dashed-box" ${goods.flag == 0?'style="border-color:red;"':''}>
                <b style="display: none;" num="${goods.id}" tips-name="${goods.goods_name}"></b>
                <a href="/index?c=SetGoods&num=${goods.id}">
                    <div class="goods-img">
                        <img src="./image/${goods.goods_pic}" alt="">
                    </div>
                    <span class="goods-text">${goods.goods_name}</span>
                </a>
            </div>
        </c:forEach>
    </div>
</body>
<script src="./js/goodsList.js"></script>
</html>
