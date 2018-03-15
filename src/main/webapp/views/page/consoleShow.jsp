<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
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
                        <a href="${pageContext.request.contextPath}/views/page/consoleShow.jsp">首页</a>
                    </li>
                    <li class="active">控制台</li>
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

    <div class="footer">
        <div class="footer-inner">
            <!-- #section:basics/footer -->
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">店小二</span>
                            江苏环科网络&copy; 2018
						</span>

                &nbsp; &nbsp;
            </div>

            <!-- /section:basics/footer -->
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->
<jsp:include page="${pageContext.request.contextPath}/common/page/contentFooter.jsp"/>
</body>
</html>
