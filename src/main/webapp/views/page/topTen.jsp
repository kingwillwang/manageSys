<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>十大品牌管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
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
                    <li class="active">十大品牌</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        十大品牌管理
                    </h1>
                </div>
                <div class="page-body">
                    <table id="dg-table" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                            url="${pageContext.request.contextPath}/website/topTenList" striped="true" pageSize="10"
                            toolbar="#barTools" fit="true">
                        <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="websiteName" width="20" align="center">品牌名称</th>
                            <th field="createDate" width="20" align="center">创建时间</th>
                            <th field="modifyDate" width="20" align="center">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                    <div id="barTools" style="justify-content: flex-end;">
                        <div class="toolRight">
                            <a href="javascript:openAddWindow()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                            <span>|</span>
                            <a href="javascript:removeTopTen()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">移除</a>
                        </div>
                    </div>
                    <div id="win-detail" class="easyui-dialog" style="width:700px;height:620px;padding:5px;" closed="true" buttons="#dlg-buttons">
                        <table id="detailTable" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                                pageSize="10"  striped="true" fit="true" toolbar="#barTools-all" >
                            <thead>
                            <tr>
                                <th field="cb" checkbox="true" align="center"></th>
                                <th field="websiteName" width="20" align="center">品牌名称</th>
                                <th field="createDate" width="20" align="center">创建时间</th>
                                <th field="modifyDate" width="20" align="center">修改时间</th>
                            </tr>
                            </thead>
                        </table>
                        <div id="barTools-all" style="justify-content: flex-start">
                            <div class="toolLeft">
                                &nbsp;&nbsp;名称：&nbsp;
                                <input type="text" id="s_websiteName" size="20" onkeydown="if(event.keyCode==13) searchWebsite()"/>
                                <a href="javascript:searchWebsite()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
                            </div>
                        </div>
                        <div id="dlg-buttons">
                            <a href="javascript:saveTopTen()" class="easyui-linkbutton" iconCls="icon-ok">添加</a>
                            <a href="javascript:closeWindow()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/views/js/topTen.js"></script>
</body>
</html>