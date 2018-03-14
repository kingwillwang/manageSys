<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <ul class="nav nav-list">
        <li class="active">
            <a href="index.html">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 控制台 </span>
            </a>
        </li>

        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-edit"></i>
                <span class="menu-text"> 表单 </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li>
                    <a href="form-elements.html">
                        <i class="icon-double-angle-right"></i>
                        表单组件
                    </a>
                </li>

                <li>
                    <a href="form-wizard.html">
                        <i class="icon-double-angle-right"></i>
                        向导提示 &amp; 验证
                    </a>
                </li>

                <li>
                    <a href="wysiwyg.html">
                        <i class="icon-double-angle-right"></i>
                        编辑器
                    </a>
                </li>

                <li>
                    <a href="dropzone.html">
                        <i class="icon-double-angle-right"></i>
                        文件上传
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