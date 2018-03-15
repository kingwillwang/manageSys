<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
</head>
<body class="no-skin">
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        首页
                    </li>
                    <li class="active">用户管理</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        用户信息
                    </h1>
                </div>


            </div>
        </div>
    </div>

    <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
</div>
<%--<script src="${pageContext.request.contextPath}/views/js/userManage.js"></script>--%>
</body>
</html>