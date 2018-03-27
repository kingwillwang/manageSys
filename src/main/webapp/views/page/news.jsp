<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>新闻管理</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/news.css">
    <script src="${pageContext.request.contextPath}/common/js/ajaxfileupload.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor/themes/default/default.css"/>
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>
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
                    <li class="active">新闻中心</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        新闻管理
                    </h1>
                </div>
                <div class="page-body">
                    <table id="dg-table" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                            url="${pageContext.request.contextPath}/news/newsList" striped="true" pageSize="10"
                            toolbar="#barTools" fit="true">
                        <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="id" width="10%" align="center" hidden="true">编号</th>
                            <th field="newsTitle" width="200" align="center">标题</th>
                            <th field="summary" width="200" align="center">摘要</th>
                            <th field="countNum" width="200" align="center">点击量</th>
                            <th field="createDate" width="150" align="center">创建时间</th>
                            <th field="content" width="70" align="center"
                                formatter="formatHref">操作
                            </th>
                        </tr>
                        </thead>
                    </table>
                    <div id="barTools">
                        <div class="toolLeft">
                            &nbsp;&nbsp;标题：&nbsp;
                            <input type="text" id="s_newsTitle" size="50" onkeydown="if(event.keyCode==13) searchNews()"/>
                            <a href="javascript:searchNews()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
                        </div>
                        <div class="toolRight">
                            <a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                            <span>|</span>
                            <a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
                            <span>|</span>
                            <a href="javascript:deleteItems()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                        </div>
                    </div>
                    <div id="dlg" class="easyui-dialog" closed="true" buttons="#dlg-buttons">
                        <form id="fm" class="form-horizontal" method="post" style="width: 100%;height: 100%;">
                            <input type="hidden" id="id" name="id">
                            <div class="form-group">
                                <label for="newsTitle" class="col-sm-2 control-label fm-lab">标题:</label>
                                <div class="col-sm-10">
                                    <input class="form-control easyui-textbox" type="text" name="newsTitle" id="newsTitle"
                                           data-options="prompt:'请输入标题'" style="width: 100%;height: 34px"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="titleImg" class="col-sm-2 control-label fm-lab">标题图片:</label>
                                <input type="hidden" id="titleImg" name="titleImg">
                                <input type="file" id="upFile" name="file" style="display:none" accept="image/png,image/jpeg">
                                <div class="input-group col-sm-10">
                                    <div class="input-group-btn">
                                        <a class="btn btn-info" onclick="$('input[id=upFile]').click();">选择文件</a>
                                    </div>
                                    <input id="photoCover" class="form-control" type="text" readonly style="height:34px;"/>
                                    <div class="input-group-btn">
                                        <a class="btn btn-primary" id="uploadImg">上传</a>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="summary" class="col-sm-2 control-label fm-lab">摘要:</label>
                                <div class="col-sm-10" style="padding-left: 0;padding-top: 5px">
                                    <textarea class="form-control" id="summary" name="summary" rows="4" style="resize: none"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="editor" class="col-sm-4 control-label fm-lab">内容:</label>
                                <div class="col-sm-12" style="padding-left: 0;padding-top: 5px">
                                    <textarea id="editor" class="form-control" style="width:350px;height:330px;visibility:hidden;"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="dlg-buttons">
                        <a href="javascript:saveNews()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
                        <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                    </div>
                </div>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/views/js/news.js"></script>
</body>
</html>