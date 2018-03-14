<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="shortcut icon" href="#" />
    <link href="http://apps.bdimg.com/libs/animate.css/3.1.0/animate.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/css/htmleaf-demo.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/css/login.css">
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/login/js/login.js"></script>
</head>

<body>
<div class="htmleaf-container">
    <header class="htmleaf-header">
        <h1>店小二后台管理系统<span>&copy; 江苏环科网络</span></h1>
    </header>
    <div class="demo form-bg animated fadeInDown" style="padding: 20px 0;">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <form class="form-horizontal" id="adminlogin" method="post" name="adminlogin" onsubmit="return false" action="#">
                        <span class="heading">用户登录</span>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="用户名" name="userName" id="userName" required/>
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="form-group help">
                            <input type="password" class="form-control" placeholder="密　码" name="password" id="password" required/>
                            <i class="fa fa-lock"></i>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-default text" onclick="javascript:adminlogin.reset();return false;">
                                重置
                            </button>
                            <button type="submit" class="btn btn-default right" onclick="javascript:login();">登录</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
