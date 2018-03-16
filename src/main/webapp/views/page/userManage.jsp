<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/userManage.css">
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

            <div class="page-content" style="font-size: 18px">
                <div class="page-header">
                    <h1>
                        用户信息
                    </h1>
                </div>

                <table id="userTable" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                        scrollbarSize="0" url="${pageContext.request.contextPath}/users/datagrid" singleSelect="true"
                        pageSize="10" toolbar="#userTools" striped="true">
                    <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="id" width="50" align="center">编号</th>
                            <th field="userName" width="50" align="center">用户名</th>
                        </tr>
                    </thead>
                </table>
                <div id="userTools">
                    <div class="toolLeft">
                        &nbsp;&nbsp;用户名：&nbsp;
                        <input type="text" id="s_userName" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
                        <a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
                    </div>
                    <div class="toolRight">
                        <a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                        <a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
                        <a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                    </div>
                </div>

                <div id="userAddDlg" class="easyui-dialog" closed="true" buttons="#dlg-buttons">
                    <form id="fm" method="post" class="form-horizontal" style="overflow: hidden;width: 100%">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="userName" name="userName" required placeholder="请输入名字">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码:</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" name="password" required placeholder="请输入密码">
                            </div>
                        </div>
                    </form>
                </div>

                <div id="dlg-buttons">
                    <a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
                    <a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
</div>
<script src="${pageContext.request.contextPath}/views/js/userManage.js"></script>
</body>
</html>