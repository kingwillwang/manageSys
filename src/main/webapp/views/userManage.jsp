<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户信息管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/base.jsp"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/userManage.js"></script>
</head>
<body style="margin:1px;">
<table id="dg" title="用户管理" class="easyui-datagrid"  pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/users/datagrid" fit="true" toolbar="#tb" fitColumns="true" scrollbarSize="0">
    <thead>
        <tr>
            <th field="cb" checkbox="true" align="center"></th>
            <th field="userName" align="center" width="100">用户名</th>
        </tr>
    </thead>
</table>
<div id="tb">
    <div style="height: 30px">
        <a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openWatchUserDialog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查看信息</a>
        <span style="float: right;margin-right: 5px">
            用户名：&nbsp;&nbsp;
            <input type="text" id="s_userName" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
            <a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
        </span>
    </div>
</div>

<div id="dlg" class="easyui-dialog" style="width: 350px;height:180px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" id="userName" name="userName" class="easyui-validatebox" required="true"/>
                    <span style="color: red">&nbsp;*</span>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="text" id="password" name="password" class="easyui-validatebox" required="true"/>
                    <span style="color: red">&nbsp;*</span>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

<div id="win-detail" class="easyui-window" title="登录详情" style="width: 350px;height:180px" closed="true">
    11111
    <%--<table id="dg-detail" class="easyui-datagrid"  pagination="true" rownumbers="true"--%>
           <%--url="${pageContext.request.contextPath}/users/datagrid" fit="true" fitColumns="true" scrollbarSize="0">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th field="cb" checkbox="true" align="center"></th>--%>
            <%--<th field="userName" align="center" width="100">用户名</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
    <%--</table>--%>
</div>

</body>
</html>