$(function () {
    checkCookie();
    initDialog();
    logout();
    initTab();
});


function initDialog() {
    //override dialog's title function to allow for HTML titles
    $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
        _title: function (title) {
            var $title = this.options.title || '&nbsp;';
            if (("title_html" in this.options) && this.options.title_html == true)
                title.html($title);
            else title.text($title);
        }
    }));
}

function initTab() {
    <!-- 设置窗口大小 -->
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

    <!-- 结束 -->
}
