<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
    %>
    <script>
        var BasePath = "<%=basePath%>";
    </script>>

    <link href= "${pageContext.request.contextPath}/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
    <script src="${pageContext.request.contextPath}/js/common.js"></script>
</head>

<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown" style="width: 400px">
    <div>
        <div>
            <h1 class="logo-name" style="font-size: 120px;margin-bottom: 20px;letter-spacing:0">店小二</h1>
        </div>
        <h3>欢迎使用 后台管理系统</h3>
        <form class="m-t" role="form" id="adminlogin" method="post" name="adminlogin" onsubmit="return false" action="#">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名" name="userName" id="userName" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password" id="password" required="">
            </div>
            <button type="button" class="btn btn-primary block full-width m-b" onclick="login();">登 录</button>
            <p class="text-muted text-center">
                <a href="#" onclick="adminlogin.reset();return false;">
                    <small>重置</small>
                </a>
            </p>
        </form>
    </div>
</div>
</body>
</html>
