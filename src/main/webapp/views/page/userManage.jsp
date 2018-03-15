<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <%--<link href="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.css" rel="stylesheet">--%>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/common/js/bootstrap-table-zh-CN.min.js"></script>
    <script src="${pageContext.request.contextPath}/views/js/userManage.js"></script>
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
                    <li class="active">用户管理</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        用户信息
                    </h1>
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="userTable" data-classes="table table-bordered table-hover" data-row-style="rowStyle"
                                       data-click-to-select="true" data-single-select="true">
                                    <thead>
                                        <tr>
                                            <th data-checkbox="true" data-align="center"></th>
                                            <th data-field="id" data-align="center" >编号</th>
                                            <th data-field="userName" data-align="center" >姓名</th>
                                            <th data-field="password" data-align="center">密码</th>
                                            <th data-field="crateDate" data-align="center">
                                                <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                                                创建时间
                                            </th>
                                            <%--<th data-field="action" data-formatter="actionFormatter" data-events="actionEvents">操作</th>--%>
                                        </tr>
                                    </thead>
                                </table>

                                <%--<div id="userToolbar" class="btn-group text-right">--%>
                                    <%--<button class="btn btn-default" id="user_add">--%>
                                        <%--<i class="glyphicon glyphicon-plus"></i>--%>
                                    <%--</button>--%>
                                <%--</div>--%>
                            </div>
                        </div>
                        <!-- PAGE CONTENT ENDS -->
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
</div>
<jsp:include page="${pageContext.request.contextPath}/common/page/contentFooter.jsp"/>
</body>
</html>