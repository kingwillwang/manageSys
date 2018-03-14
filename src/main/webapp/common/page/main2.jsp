<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>系统主页</title>
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css"/>
    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-fonts.css"/>
    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet"
          id="main-ace-style"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css"/>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <style>
        .widget-header {
            overflow: hidden;
        }

        .widget-header.showctl .widget-toolbar-ctl {
            display: block;
        }

        .widget-header .widget-toolbar-box {
            width: 90%;
            overflow: hidden;
        }

        .widget-header .widget-toolbar {
            width: 9999px;
        }

        .widget-toolbar-ctl {
            padding: 6px 8px !important;
            margin-top: 4px !important;
            display: none;
        }
    </style>

    <!-- ace settings handler -->
    <script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>
    <jsp:include page="${pageContext.request.contextPath}/common/page/base.jsp"/>
    <script src="${pageContext.request.contextPath}/common/js/main.js"></script>
</head>

<body>

<!-- /section:basics/navbar.layout -->
<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>

    <!-- #section:basics/sidebar -->
    <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>


        <ul class="nav nav-list">
            <li class="active">
                <a href="index_content.html" data-default-tab="true" data-target="menuIframe"
                   data-tab-title="Dashboard">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>

                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> Tables </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="tables.html" data-target="menuIframe" data-tab-title="Simple &amp; Dynamic">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Simple &amp; Dynamic
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="jqgrid.html" data-target="menuIframe" data-tab-title="jqGrid plugin">
                            <i class="menu-icon fa fa-caret-right"></i>
                            jqGrid plugin
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> Forms </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="form-elements.html" data-target="menuIframe" data-tab-title="Form Elements">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Form Elements
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="form-elements-2.html" data-target="menuIframe" data-tab-title="Form Elements 2">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Form Elements 2
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="form-wizard.html" data-target="menuIframe" data-tab-title="Wizard &amp; Validation">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Wizard &amp; Validation
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="wysiwyg.html" data-target="menuIframe" data-tab-title="Wysiwyg &amp; Markdown">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Wysiwyg &amp; Markdown
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="dropzone.html" data-target="menuIframe" data-tab-title="Dropzone File Upload">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Dropzone File Upload
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

        </ul><!-- /.nav-list -->


        <!-- /section:basics/sidebar.layout.minimize -->
    </div>

    <!-- /section:basics/sidebar -->
    <div class="iframe_box main-content">
        <div class="widget-box transparent padding-0" id="iframe_tab_box">
            <div class="widget-header">
                <a href="javascript:;" class="pull-left widget-toolbar-ctl" data-action="prev">
                    <i class="glyphicon glyphicon-chevron-left"></i>
                </a>
                <div class="widget-toolbar-box pull-left">
                    <div class="widget-toolbar no-border pull-left">
                        <ul class="nav nav-tabs pull-left" id="recent-tab">
                        </ul>
                    </div>
                </div>
                <a href="javascript:;" class="pull-left widget-toolbar-ctl" data-action="next">
                    <i class="glyphicon glyphicon-chevron-right"></i>
                </a>
            </div>
            <div class="widget-body">
                <div class="widget-main padding-4">
                    <div class="tab-content padding-0 hidden" id="iframe_tab_content">
                    </div>
                </div><!-- /.widget-main -->
            </div><!-- /.widget-body -->
        </div>
    </div>

</div>
<!-- /.main-container -->

<!-- basic scripts -->



<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.custom/jquery-ui.custom.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/index.min.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/assets/js/src/elements.scroller.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.colorpicker.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.fileinput.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.typeahead.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.wysiwyg.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.spinner.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.treeview.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.wizard.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/elements.aside.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.basics.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.scrolltop.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.ajax-content.js"></script>
<%--<script src="${pageContext.request.contextPath}/assets/js/src/ace.touch-drag.js"></script>--%>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.sidebar.js"></script>
<%--<script src="${pageContext.request.contextPath}/assets/js/src/ace.sidebar-scroll-1.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/assets/js/src/ace.submenu-hover.js"></script>--%>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.widget-box.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.settings.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.settings-rtl.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.settings-skin.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.widget-on-reload.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/src/ace.searchbox-autocomplete.js"></script>

<!-- 设置窗口大小 -->
<script>
    // 设置窗口大小
    var setIframeHeight = function () {
        var height = document.documentElement.clientHeight;
        height = height - $('#navbar').height() - $('#iframe_tab_box .widget-header').height() - 16;
        $('#iframe_tab_content').css('height', height).removeClass('hidden');
    };
    $(window).on('resize', setIframeHeight).trigger('resize');
    // 打开新的tab
    var openTab = function (url, title, key) {
        var $navtabs = $('#iframe_tab_box .nav-tabs');
        var $tab = $navtabs.find('a[data-key="' + key + '"]');
        if (!$tab.length) {
            $('<li><a data-toggle="tab" data-key="' + key + '" href="#' + key + '-tab">' + title + '<i class="ace-icon fa fa-times"></i></a></li>').appendTo($navtabs);
            $('<div id="' + key + '-tab" class="tab-pane active" style="height: 100%;">' +
                '<iframe src="' + url + '" style="width: 100%; height: 100%; border: none;"></iframe>' +
                '</div>').appendTo('#iframe_tab_content');
            $navtabs.find('a[data-key="' + key + '"]').trigger('click');
        }
        else {
            $navtabs.find('a[data-key="' + key + '"]').trigger('click');
            // setTimeout(function() {
            $tab.trigger('click');
            // }, 100);
        }
    }
    $('#iframe_tab_box .widget-header').on('resize', function () {
        var $self = $(this);
        var $navbars = $self.find('.nav-tabs');
        if ($navbars.width() > $self.width()) {
            $self.addClass('showctl');
        }
        else {
            $self.removeClass('showctl');
        }
    }).on('showLast', function () {
        var $self = $(this);
        var $navbars = $self.find('.nav-tabs');
        var marginLeft = Math.min(0, $self.width() - $navbars.width());
        $navbars.css('margin-left', marginLeft).data('marginLeft', marginLeft);
    }).on('next', function () {
        var $self = $(this);
        var $navbars = $self.find('.nav-tabs');
        var marginLeft = parseInt($navbars.data('marginLeft')) || 0;
        marginLeft -= 100;
        $navbars.css('margin-left', marginLeft).data('marginLeft', marginLeft);
    }).on('prev', function () {
        var $self = $(this);
        var $navbars = $self.find('.nav-tabs');
        var marginLeft = parseInt($navbars.data('marginLeft')) || 0;
        marginLeft = Math.min(0, marginLeft + 100);
        $navbars.css('margin-left', marginLeft).data('marginLeft', marginLeft);
    }).find('.widget-toolbar-ctl').on('click', function () {
        var $self = $(this);
        $('#iframe_tab_box .widget-header').trigger($self.data('action'));
    });
    // 侦听tab关闭事件
    $('#iframe_tab_box .nav-tabs').on('click', 'i.fa', function () {
        var $li = $(this).parents('li');
        var index = $li.index();
        var activeLast = false;
        if ($li.hasClass('active')) {
            activeLast = true;
        }
        $li.remove();
        $('#iframe_tab_content .tab-pane:eq(' + index + ')').remove();
        if (activeLast) {
            $('#iframe_tab_box .nav-tabs li:last').find('a').trigger('click');
        }
        $('#iframe_tab_box .widget-header').trigger('resize');
    });
    // 侦听新开窗口事件
    $('#sidebar').on('click', '.nav-list a', function () {
        var $el = $(this);
        if ($el.data('target') == 'menuIframe') {
            try {
                var key = $el.data('key');
                if (!key) {
                    var key = 'iframe_tab' + parseInt(1000000 * Math.random());
                    $el.data('key', key);
                }
                openTab($el.attr('href'), $el.data('tabTitle'), key);
                // 修改菜单高亮
                if (!$el.parent().hasClass('active')) {
                    var $submenu = $el.parents('ul.submenu');
                    var $submenuparent = false;
                    // debugger;
                    if ($submenu.length) {
                        var $submenuparent = $submenu.parent();
                        if ($submenuparent.hasClass('active')) {
                            $submenuparent.find('li.active').removeClass('active');
                        }
                        else {
                            $('#sidebar').find('li.active').removeClass('active');
                            $submenuparent.addClass('active');
                        }
                        $el.parent().addClass('active');
                    }
                    else {
                        $('#sidebar').find('li.active').removeClass('active');
                        $el.parent().addClass('active');
                    }
                }
                $('#iframe_tab_box .widget-header').trigger('resize');
            } catch (e) {
                console.error(e)
            }
            return false;
        }
    }).find('.nav-list a[data-default-tab]').trigger('click');

</script>
<!-- 结束 -->
</body>
</html>
