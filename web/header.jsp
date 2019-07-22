<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    if(${empty sessionScope.userInfo}){location.href = "/index?c=Login";}
</script>
<link rel="stylesheet" href="./css/public.css">
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
<script src="./js/public.js"></script>