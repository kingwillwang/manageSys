function logout() {
    $("#id-btn-outSys").on("click",function (e) {
        e.preventDefault();
        $("#outSys-message").removeClass('hide').dialog({
            modal: true,
            title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-exit'></i>系统提醒</h4></div>",
            title_html: true,
            buttons: [
                {
                    text: "Cancel",
                    "class": "btn btn-sm btn-out",
                    click: function () {
                        $(this).dialog("close");
                    }
                },
                {
                    text: "OK",
                    "class": "btn btn-danger btn-sm btn-out",
                    click: function () {
                        clearCookie();
                    }
                }
            ]
        });
    });
}