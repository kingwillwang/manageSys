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
                            <a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
                            <span>|</span>
                            <a href="javascript:deleteWebsite()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                        </div>
                    </div>
                    <div id="dlg" class="easyui-dialog" closed="true" buttons="#dlg-buttons">
                        <form id="fm" class="form-horizontal" method="post" style="width: 100%;height: 100%;overflow: hidden">
                            <div class="form-group">
                                <label for="websiteName" class="col-sm-2 control-label fm-lab">名称:</label>
                                <div class="col-sm-10">
                                    <input class="form-control easyui-textbox" type="text" name="websiteName" id="websiteName"
                                           data-options="prompt:'请输入品牌名称'" style="width: 100%;height: 34px"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="websiteUrl" class="col-sm-2 control-label fm-lab">地址:</label>
                                <div class="col-sm-10">
                                    <input class="form-control easyui-textbox" type="text" name="websiteUrl" id="websiteUrl"
                                           data-options="prompt:'请输入品牌链接地址'" style="width: 100%;height: 34px"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="websiteLogo" class="col-sm-2 control-label fm-lab">Logo:</label>
                                <div class="col-sm-10">
                                    <input class="easyui-filebox form-control" name="websiteLogo" id="websiteLogo" style="width: 100%;height: 34px"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label fm-lab">推荐品牌:</label>
                                <div class="col-sm-4">
                                    <label class="radio-inline">
                                        <input type="radio" name="isRecommend" value="1" checked>是
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="isRecommend" value="0">否
                                    </label>
                                </div>
                                <label for="websiteSort" class="col-sm-1 control-label fm-lab" style="text-align: center">排序:</label>
                                <div class="col-sm-5">
                                    <select class="easyui-combobox form-control" id="websiteSort" style="width: 100%;height: 34px">
                                        <option value="A">A</option><option value="B">B</option><option value="C">C</option><option value="D">D</option><option value="E">E</option><option value="F">F</option>
                                        <option value="G">G</option><option value="H">H</option><option value="I">I</option><option value="J">J</option><option value="K">K</option><option value="L">L</option>
                                        <option value="M">M</option><option value="N">N</option><option value="O">O</option><option value="P">P</option><option value="Q">Q</option><option value="R">R</option>
                                        <option value="S">S</option><option value="T">T</option><option value="U">U</option><option value="V">V</option><option value="W">W</option><option value="X">X</option>
                                        <option value="Y">Y</option><option value="Z">Z</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="websiteType" class="col-sm-2 control-label fm-lab">类别:</label>
                                <div class="col-md-10">
                                    <select class="easyui-combotree" id="websiteType" style="width: 100%;height: 34px"
                                            data-options="prompt:'请选择品牌类型'" multiple></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="websiteDesc" class="col-sm-4 control-label fm-lab">品牌描述:</label>
                                <div class="col-md-12" style="padding-left: 0;padding-top: 5px">
                                    <textarea class="form-control" id="websiteDesc" rows="8" style="resize: none"></textarea>
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