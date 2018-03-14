<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="${pageContext.request.contextPath}/common/page/contentBase.jsp"/>
<body>
<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="${pageContext.request.contextPath}/views/page/consoleShow.jsp">首页</a>
            </li>
            <li class="active">控制台</li>
        </ul>
    </div>

    <div class="page-content">
        <div class="row" style="margin: 0">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <div class="alert alert-block alert-success">
                    <button type="button" class="close" data-dismiss="alert">
                        <i class="icon-remove"></i>
                    </button>
                    <i class="icon-ok green"></i>
                    欢迎使用
                    <strong class="green">
                        店小二后台管理系统
                        <small>(v1.0)</small>
                    </strong>
                </div>
                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div>
</body>
