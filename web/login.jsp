<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15 0015
  Time: 下午 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/public.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div id="login" class="dashed-box">
        <span class="login-header">
            login
        </span>
        <div class="err-msg">${param.errMsg}</div>
        <form action="/index?c=Login" method="post">
            <div class="login-ipt">
                <input id="user-ipt" class="dashed-ipt" type="text" name="user" value="请输入用户名" ini-val="请输入用户名">
                <input id="pwd-ipt" class="dashed-ipt" type="text" name="pwd" value="请输入密码" ini-val="请输入密码">

            </div>
            <div class="login-btn">
                <input id="sub-btn" class="login-submit btn submit-btn" type="submit" value="登录">
                <input class="dashed-box btn login-registered" type="button" value="注册" onclick="location.href='/index?c=Registered'">
            </div>
        </form>
    </div>
</body>
<script src="./js/index.js"></script>
</html>
