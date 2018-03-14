<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/header/css/header.css" />
<script src="${pageContext.request.contextPath}/header/js/header.js"></script>

<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="${pageContext.request.contextPath}/common/page/main.jsp" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    店小二后台管理系统
                </small>
            </a>
        </div>

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="${pageContext.request.contextPath}/assets/avatars/profile-pic.jpg" alt="Photo" />
                        <span class="user-info">
                            <small>当前用户</small>
                            ${cookie['userName'].value}
                        </span>
                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close userSetList">
                        <li>
                            <a href="#" id="id-btn-outSys" class="btn btn-sm">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

        <div id="outSys-message" class="hide">
            <div>
                确定要退出吗？
            </div>
        </div>
    </div>
</div>

