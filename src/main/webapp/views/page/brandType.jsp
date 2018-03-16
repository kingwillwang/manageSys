<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>类别管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/brandType.css">
</head>
<body>
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
                    <li class="active">品牌管理</li>
                    <li class="active">分类类别</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        品牌分类
                    </h1>
                </div>
                <div class="page-body">
                    <table id="dg-table" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                            url="${pageContext.request.contextPath}/brandType/firstTypeList" singleSelect="true"
                           pageSize="10" toolbar="#barTools" striped="true" fit="true">
                        <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="typeName" width="20" align="center">类型</th>
                            <th field="createDate" align="center">创建时间</th>
                            <th field="modifyDate" align="center">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                    <div id="barTools">
                        <div class="toolLeft">
                            &nbsp;&nbsp;类型：&nbsp;
                            <input type="text" id="s_typeName" size="20" onkeydown="if(event.keyCode==13) searchFirstTypes()"/>
                            <a href="javascript:searchFirstTypes()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
                        </div>
                        <div class="toolRight">
                            <a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                            <span>|</span>
                            <a href="javascript:openWatchUserDialog()" class="easyui-linkbutton" iconCls="icon-user-config" plain="true">查看详情</a>
                        </div>
                    </div>
                </div>
                <%--<div id="dlg" class="easyui-dialog" closed="true" buttons="#dlg-buttons">--%>
                    <%--<form id="fm" method="post" class="form-horizontal" style="overflow: hidden;width: 100%">--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-2 control-label">用户名:</label>--%>
                            <%--<div class="col-sm-10">--%>
                                <%--<input type="text" class="form-control" id="userName" name="userName" required placeholder="请输入名字">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                            <%--<label class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码:</label>--%>
                            <%--<div class="col-sm-10">--%>
                                <%--<input type="password" class="form-control" id="password" name="password" required placeholder="请输入密码">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</form>--%>
                <%--</div>--%>

                <%--<div id="dlg-buttons">--%>
                    <%--<a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>--%>
                    <%--<a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>--%>
                <%--</div>--%>

                <%--<div id="win-detail" class="easyui-window" title="登录详情" style="width:650px;height:560px;padding:5px;" closed="true">--%>
                    <%--<table id="detailTable" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"--%>
                           <%--scrollbarSize="0"  singleSelect="true" pageSize="10" striped="true">--%>
                        <%--<thead>--%>
                            <%--<tr>--%>
                                <%--<th field="loginTime" width="50" align="center">登陆时间</th>--%>
                                <%--<th field="loginIp" width="50" align="center">登录IP</th>--%>
                            <%--</tr>--%>
                        <%--</thead>--%>
                    <%--</table>--%>
                <%--</div>--%>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/views/js/brandType.js"></script>
</body>
</html>