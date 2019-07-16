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
    <link rel="stylesheet" href="./css/registered.css">
    <link rel="stylesheet" href="./css/public.css">
</head>
<body>
    <form action="/index?c=Registered" method="post">
        <table>
            <tbody class="form-beautify">
                <tr>
                    <td>用户名：</td>
                    <td>
                        <input class="form-node dashed-ipt" type="text" name="user">
                        <span class="err-msg"></span>
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td>
                        <input class="form-node dashed-ipt" type="password" name="pwd">
                        <span class="err-msg"></span>
                    </td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td>
                        <input id="ckpwd" class="dashed-ipt form-node" type="password">
                        <span class="err-msg"></span>
                    </td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>
                        <label>
                            <input type="radio" name ="sex" value="1" checked>男
                        </label>
                        <label>
                            <input type="radio" name ="sex"  value="2">女
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>手机号：</td>
                    <td>
                        <input class="form-node dashed-ipt" type="text" name="phone">
                        <span class="err-msg"></span>
                    </td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td>
                        <input class="form-node dashed-ipt" type="text" name="email">
                        <span class="err-msg"></span>
                    </td>
                </tr>
                <tr>
                    <td>爱好：</td>
                    <td>
                        <textarea class="form-node dashed-ipt" name="hobbys" cols="25" rows="4"></textarea>
                        <span class="err-msg"></span>
                    </td>
                </tr>
                <tr>
                    <td>详细住址：</td>
                    <td>
                        <textarea class="form-node dashed-ipt" name="address" cols="25" rows="4"></textarea>
                        <span class="err-msg"></span>
                    </td>
                </tr>
            </tbody>
        </table>
        <input class="btn submit-btn" type="button" value="提交">
        <input class="btn dashed-box" type="button" value="返回" onclick="location.href='/index?c=Login'">
    </form>
</body>
<script src="./js/registered.js"></script>
</html>
