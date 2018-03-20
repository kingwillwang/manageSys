<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>品牌详情</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/website.css">
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
                    <li class="active">品牌详情</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        品牌详情
                    </h1>
                </div>
                <div class="page-body">
                    <table id="dg-table" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                           url="${pageContext.request.contextPath}/website/allWebsiteList" pageSize="10" toolbar="#barTools"
                           striped="true" fit="true">
                        <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="websiteName" width="20" align="center">名称</th>
                            <th field="websiteUrl" width="20" align="center">地址</th>
                            <th field="countNum" width="20" align="center" sortable="true">访问量</th>
                            <th field="modifyDate" width="20" align="center" sortable="true">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                    <div id="barTools">
                        <div class="toolLeft">
                            &nbsp;&nbsp;名称：&nbsp;
                            <input type="text" id="s_websiteName" size="20" onkeydown="if(event.keyCode==13) searchWebsite()"/>
                            <a href="javascript:searchWebsite()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
                        </div>
                        <div class="toolRight">
                            <a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                            <span>|</span>
                            <a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-set" plain="true">编辑</a>
                            <span>|</span>
                            <a href="javascript:deleteWebsite()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                        </div>
                    </div>
                    <div id="dlg" class="easyui-dialog" closed="true" buttons="#dlg-buttons">
                        <form id="fm" method="post" class="form-horizontal" style="overflow: hidden;width: 100%">
                            <div class="form-group">
                                <label class="col-sm-2 control-label center">名称:</label>
                                <div class="col-sm-10">
                                    <input type="hidden" id="typeId-first" name="typeId">
                                    <input type="text" class="form-control" id="typeName-first" name="typeName" required
                                           placeholder="请输入分类类型名称">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="dlg-buttons">
                        <a href="javascript:saveWebsite()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
                        <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                    </div>
                </div>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/views/js/website.js"></script>
</body>
</html>