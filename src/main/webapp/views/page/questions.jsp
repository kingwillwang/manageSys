<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>常见问答</title>
    <jsp:include page="${pageContext.request.contextPath}/common/page/contentHeader.jsp"/>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/css/questions.css">
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
                    <li class="active">常见问答</li>
                </ul>
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        常见问答管理
                    </h1>
                </div>
                <div class="page-body">
                    <table id="dg-table" class="easyui-datagrid" pagination="true" fitColumns="true" rownumbers="true"
                            url="${pageContext.request.contextPath}/questions/questionsList" striped="true" pageSize="10"
                            toolbar="#barTools" fit="true">
                        <thead>
                        <tr>
                            <th field="cb" checkbox="true" align="center"></th>
                            <th field="question" width="20" align="center">问题</th>
                            <th field="answer" width="20" align="center">回答</th>
                        </tr>
                        </thead>
                    </table>
                    <div id="barTools">
                        <div class="toolLeft">
                            &nbsp;&nbsp;问题：&nbsp;
                            <input type="text" id="s_question" size="50" onkeydown="if(event.keyCode==13) searchQuestions()"/>
                            <a href="javascript:searchQuestions()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
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
                        <form id="fm" method="post" class="form-horizontal" style="overflow: hidden;width: 100%">
                            <input type="hidden" id="questionId" name="id">
                            <div class="form-group">
                                <label for="question" class="col-sm-4 control-label fm-lab">问&nbsp;&nbsp;题:</label>
                                <div class="col-md-12" style="padding-left: 0;padding-top: 5px">
                                    <textarea class="form-control" id="question" name="question" rows="3" style="resize: none"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="answer" class="col-sm-4 control-label fm-lab">回&nbsp;&nbsp;答:</label>
                                <div class="col-md-12" style="padding-left: 0;padding-top: 5px">
                                    <textarea class="form-control" id="answer" name="answer" rows="3" style="resize: none"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="dlg-buttons">
                        <a href="javascript:saveItem()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
                        <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                    </div>
                </div>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/common/page/footer.jsp"/>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/views/js/questions.js"></script>
</body>
</html>