<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>友情链接管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/friendlyLink.css">
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
                    <li class="active">友情链接</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        友情链接管理
                    </h1>
                </div>
                <div class="page-body">
                    <table id="dg-table" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                            url="${pageContext.request.contextPath}/friendlyLink/linkList" striped="true" pageSize="10"
                            toolbar="#barTools" fit="true">
                        <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="linkName" width="20" align="center">链接名称</th>
                            <th field="linkUrl" width="20" align="center">链接地址</th>
                            <th field="createDate" width="20" align="center">创建时间</th>
                            <th field="modifyDate" width="20" align="center">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                    <div id="barTools">
                        <div class="toolLeft">
                            &nbsp;&nbsp;名称：&nbsp;
                            <input type="text" id="s_linkName" size="20" onkeydown="if(event.keyCode==13) searchLink()"/>
                            <a href="javascript:searchLink()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
                        </div>
                        <div class="toolRight">
                            <a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                            <span>|</span>
                            <a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
                            <span>|</span>
                            <a href="javascript:deleteLinks()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                        </div>
                    </div>
                    <div id="link-dlg" class="easyui-dialog" closed="true" buttons="#dlg-buttons">
                        <form id="fm" method="post" class="form-horizontal" style="overflow: hidden;width: 100%">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名&nbsp;&nbsp;称:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="linkName" name="linkName" required placeholder="请输入外链名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">地&nbsp;&nbsp;址:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="linkUrl" name="linkUrl" required placeholder="请输入外链地址">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="dlg-buttons">
                        <a href="javascript:saveLink()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
                        <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                    </div>
                </div>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/views/js/friendlyLink.js"></script>
</body>
</html>