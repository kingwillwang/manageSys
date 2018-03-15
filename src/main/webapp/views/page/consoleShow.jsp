<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>控制台</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
</head>
<body class="no-skin">
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        首页
                    </li>
                    <li class="active">
                        控制台
                    </li>
                </ul>
            </div>

            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">
                <div class="page-header">
                    <h1>
                        欢迎使用
                        <strong class="green">
                            店小二后台管理系统
                            <small>(v1.0)</small>
                        </strong>
                    </h1>
                </div>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
    <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
</div><!-- /.main-container -->
<jsp:include page="${pageContext.request.contextPath}/common/page/contentFooter.jsp"/>
</body>
</html>
