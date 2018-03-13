<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <title>系统主页</title>
    <jsp:include page="${pageContext.request.contextPath}/views/base.jsp"/>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #ffff">
    <table style="width: 100%;height: 100%">
        <tr>
            <td width="50%"></td>
            <td style="vertical-align: center;font-size: 20px;color: #8B8B8B;font-family: '楷体';
                        text-align: right; width: 50%">
                <strong>当前用户：</strong> ${cookie['userName'].value}【管理员】
                <a href="javascript:logout()" class="easyui-linkbutton" style="padding-right: 10px"
                   data-options="plain:true,iconCls:'icon-exit'" >安全退出</a>
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <p align="center" style="padding-top: 100px;color: grey;font-size: 50px">
                欢迎使用
            </p>
            <p align="center" style="padding-top: 20px;color: grey;font-size: 50px">
                店小二后台管理系统
            </p>
        </div>
    </div>
</div>
<div region="west" style="width: 200px;height:500px;" title="导航菜单" split="true">
    <div class="easyui-accordion">
        <%--<div title="资讯管理" data-options="selected:true,iconCls:'icon-wenzhangs'" style="padding: 10px;height:10px;">--%>
            <%--<a href="javascript:openTab('文章管理','articleManage-ke.jsp','icon-wenzhang')" class="easyui-linkbutton"--%>
                    <%--data-options="plain:true,iconCls:'icon-wenzhang'" style="width: 150px;"> kindEditor</a>--%>
        <%--</div>--%>
        <%--<div title="图片管理" data-options="iconCls:'icon-shouye'"--%>
             <%--style="padding:10px">--%>
            <%--<a--%>
                    <%--href="javascript:openTab(' 图片设置','pictureManage.jsp?type=1&grade=1','icon-tupians')"--%>
                    <%--class="easyui-linkbutton"--%>
                    <%--data-options="plain:true,iconCls:'icon-tupian'"--%>
                    <%--style="width: 150px;"> 图片设置</a>--%>
        <%--</div>--%>
        <div title="系统管理" data-options="iconCls:'icon-item'" style="padding:10px;border:none;">
            <a href="javascript:openTab('管理员列表','userManage.jsp','icon-lxr')"
               class="easyui-linkbutton l-btn-left" data-options="plain:true,iconCls:'icon-lxr'" style="width: 150px;text-align: left">
                管理员列表</a>
        </div>
    </div>
</div>
</body>
</html>