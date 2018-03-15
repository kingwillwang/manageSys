<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>用户管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <style>
        .datagrid *{
            -webkit-box-sizing: content-box;
            -moz-box-sizing: content-box;
            box-sizing: content-box;
        }
    </style>
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

                <table id="userTable" class="easyui-datagrid " pagination="true" fitColumns="true" pagination="true"
                       rownumbers="true" scrollbarSize="0" url="${pageContext.request.contextPath}/users/datagrid" fit="true"
                       toolbar="#tb">
                    <thead>
                        <tr>
                            <th field="cb" checkbox="true" class="center">
                                <label class="pos-rel">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <%--<th field="cb" checkbox="true" class="ace" align="center"></th>--%>
                            <th field="id" width="100" align="center">编号</th>
                            <th field="userName" width="100" align="center">用户名</th>
                        </tr>
                    </thead>
                </table>
                <%--<div id="tb">--%>
                    <%--<div>--%>
                        <%--<a href="javascript:openUserAddDialog()" class="easyui-linkbutton"--%>
                           <%--iconCls="icon-add" plain="true">添加</a> <a--%>
                            <%--href="javascript:openUserModifyDialog()" class="easyui-linkbutton"--%>
                            <%--iconCls="icon-edit" plain="true">修改</a> <a--%>
                            <%--href="javascript:deleteUser()" class="easyui-linkbutton"--%>
                            <%--iconCls="icon-remove" plain="true">删除</a>--%>
                    <%--</div>--%>
                    <%--<div>--%>
                        <%--&nbsp;用户名：&nbsp;<input type="text" id="s_userName" size="20"--%>
                                               <%--onkeydown="if(event.keyCode==13) searchUser()"/> <a--%>
                            <%--href="javascript:searchUser()" class="easyui-linkbutton"--%>
                            <%--iconCls="icon-search" plain="true">搜索</a>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div id="dlg" class="easyui-dialog"--%>
                     <%--style="width: 620px;height:250px;padding: 10px 20px" closed="true"--%>
                     <%--buttons="#dlg-buttons">--%>
                    <%--<form id="fm" method="post">--%>
                        <%--<table cellspacing="8px">--%>
                            <%--<tr>--%>
                                <%--<td>用户名：</td>--%>
                                <%--<td><input type="text" id="userName" name="userName"--%>
                                           <%--class="easyui-validatebox" required="true"/>&nbsp;<font--%>
                                        <%--color="red">*</font>--%>
                                    <%--<input type="hidden" id="userId" value="0">--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                                <%--<td>密码：</td>--%>
                                <%--<td><input type="text" id="password" name="password"--%>
                                           <%--class="easyui-validatebox" required="true"/>&nbsp;<font--%>
                                        <%--color="red">*</font>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                        <%--</table>--%>
                    <%--</form>--%>
                <%--</div>--%>

                <%--<div id="dlg-buttons">--%>
                    <%--<a href="javascript:saveUser()" class="easyui-linkbutton"--%>
                       <%--iconCls="icon-ok">保存</a> <a href="javascript:closeUserDialog()"--%>
                                                   <%--class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>--%>
                <%--</div>--%>





            </div>
        </div>
    </div>

    <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
</div>
<%--<script src="${pageContext.request.contextPath}/views/js/userManage.js"></script>--%>
</body>
</html>