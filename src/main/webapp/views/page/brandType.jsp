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
                    <table id="dg-table-first" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                           url="${pageContext.request.contextPath}/brandType/firstTypeList" pageSize="10" toolbar="#barTools-first"
                           striped="true" fit="true">
                        <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="typeName" width="20" align="center">类型</th>
                            <th field="createDate" width="20" align="center">创建时间</th>
                            <th field="modifyDate" width="20" align="center">修改时间</th>
                        </tr>
                        </thead>
                    </table>
                    <div id="barTools-first">
                        <div class="toolLeft">
                            &nbsp;&nbsp;类型：&nbsp;
                            <input type="text" id="s_typeName-first" size="20" onkeydown="if(event.keyCode==13) searchFirstTypes()"/>
                            <a href="javascript:searchFirstTypes()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
                        </div>
                        <div class="toolRight">
                            <a href="javascript:openAddFirstType()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                            <span>|</span>
                            <a href="javascript:openModifyFirstType()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
                            <span>|</span>
                            <a href="javascript:deleteFirstType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                            <span>|</span>
                            <a href="javascript:openWatchSecondTypes()" class="easyui-linkbutton" iconCls="icon-set" plain="true">分类详情</a>
                        </div>
                    </div>
                    <div id="dlg-first" class="easyui-dialog" closed="true" buttons="#dlg-buttons-first">
                        <form id="fm-first" method="post" class="form-horizontal" style="overflow: hidden;width: 100%">
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
                    <div id="dlg-buttons-first">
                        <a href="javascript:saveFirstBrandType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
                        <a href="javascript:closeFirstDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                    </div>

                    <!-- 二级分类 -->
                    <div id="win-detail" class="easyui-window" style="width:650px;height:580px;padding:5px;" closed="true">
                        <input type="hidden" id="pid" name="pid">
                        <table id="detailTable" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                               pageSize="10" toolbar="#barTools-second" striped="true" fit="true">
                            <thead>
                            <tr>
                                <th field="cb" checkbox="true" align="center"></th>
                                <th field="typeName" width="20" align="center">类型</th>
                                <th field="createDate" width="20" align="center">创建时间</th>
                                <th field="modifyDate" width="20" align="center">修改时间</th>
                            </tr>
                            </thead>
                        </table>
                        <div id="barTools-second">
                            <div class="toolLeft">
                                &nbsp;&nbsp;类型：&nbsp;
                                <input type="text" id="s_typeName-second" size="20" onkeydown="if(event.keyCode==13) searchSecondTypes()"/>
                                <a href="javascript:searchSecondTypes()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
                            </div>
                            <div class="toolRight">
                                <a href="javascript:openAddSecondType()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                                <span>|</span>
                                <a href="javascript:openModifySecondType()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
                                <span>|</span>
                                <a href="javascript:deleteSecondType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                            </div>
                        </div>
                        <div id="dlg-second" class="easyui-dialog" closed="true" buttons="#dlg-buttons-second">
                            <form id="fm-second" method="post" class="form-horizontal" style="overflow: hidden;width: 100%">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label center">名称:</label>
                                    <div class="col-sm-10">
                                        <input type="hidden" id="typeId-second" name="typeId">
                                        <input type="text" class="form-control" id="typeName-second" name="typeName" required
                                               placeholder="请输入分类类型名称">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div id="dlg-buttons-second">
                            <a href="javascript:saveSecondBrandType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
                            <a href="javascript:closeSecondDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/views/js/brandType.js"></script>
</body>
</html>