<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>系统主页</title>
    <!-- basic styles -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/css/jquery-ui-1.10.3.full.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
</head>

<body>
<!-- 头部标签 -->
<jsp:include page="${pageContext.request.contextPath}/header/page/header.jsp"/>
<!-- 头部标签 -->

<!-- 主体内容 -->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <!-- 左侧导航栏 -->
        <jsp:include page="${pageContext.request.contextPath}/leftBar/page/left.jsp"/>
        <!-- 左侧导航栏 -->
        <!-- 主体 -->
        <div class="iframe_box main-content">
            <div class="widget-box transparent padding-0" id="iframe_tab_box">
                <div class="widget-header">
                    <div class="widget-toolbar-box pull-left">
                        <div class="widget-toolbar no-border pull-left">
                            <ul class="nav nav-tabs pull-left" id="recent-tab">
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="widget-body">
                    <div class="widget-main padding-4">
                        <div class="tab-content padding-0 hidden" id="iframe_tab_content">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 主体 -->
        <!-- 右侧设置换肤 -->
        <div class="ace-settings-container" id="ace-settings-container">
            <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                <i class="icon-cog bigger-150"></i>
            </div>

            <div class="ace-settings-box" id="ace-settings-box">
                <div>
                    <div class="pull-left">
                        <select id="skin-colorpicker" class="hide">
                            <option data-skin="default" value="#438EB9">#438EB9</option>
                            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                        </select>
                    </div>
                    <span>&nbsp; 选择皮肤</span>
                </div>
            </div>
        </div>
        <!-- 右侧设置换肤 -->
    </div>
</div>
<!-- 主体内容 -->
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/common/js/main.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/typeahead-bs2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.10.3.full.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>
</body>
</html>

