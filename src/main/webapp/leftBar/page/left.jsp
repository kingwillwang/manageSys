<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <ul class="nav nav-list">
        <li class="active">
            <a href="${pageContext.request.contextPath}/views/page/consoleShow.jsp" data-default-tab="true"
               data-target="menuIframe" data-tab-title="&nbsp;控制台&nbsp;&nbsp;">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 控制台 </span>
            </a>
        </li>

        <li>
            <a href="${pageContext.request.contextPath}/views/page/userManage.jsp" data-target="menuIframe"
               data-tab-title="&nbsp;用户管理&nbsp;&nbsp;">
                <i class="icon-user"></i>
                <span class="menu-text"> 用户管理 </span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-list-alt"></i>
                <span class="menu-text"> 品牌管理 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="${pageContext.request.contextPath}/views/page/brandType.jsp" data-target="menuIframe"
                       data-tab-title="&nbsp;分类类别&nbsp;&nbsp;">
                        <i class="icon-double-angle-right"></i>
                        分类类别
                    </a>
                </li>
            </ul>
        </li>

    </ul>
    <!-- 折叠 -->
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>
    <!-- 折叠 -->

    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
</div>