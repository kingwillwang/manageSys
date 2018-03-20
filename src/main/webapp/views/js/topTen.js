//打开对话框
function openAddWindow() {
    resetValue();
    searchWebsite();
    $('#win-detail').dialog('open').dialog("setTitle", "选择添加十大品牌");
    $('#detailTable').datagrid({
        url: basePath + "/website/notTopTenList"
    });
}

//关闭对话框
function closeWindow() {
    $("#win-detail").dialog("close");
}

//查询
function searchWebsite() {
    $("#detailTable").datagrid('load', {
        "websiteName": $("#s_websiteName").val()
    });
}

//重置
function resetValue() {
    $("#s_websiteName").val("");
}

//增加
function saveTopTen() {
    var selectedRows = $("#detailTable").datagrid('getSelections');
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请至少选择一条数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.ajax({
        type: "POST",
        dataType: "json",
        url: basePath + "/website/addTopTen/" + ids,
        success: function (result) {
            if (result.resultCode == 200) {
                $.messager.alert("系统提示", "操作成功！");
                closeWindow();
                $("#dg-table").datagrid("reload");
            } else {
                $.messager.alert("系统提示", "操作失败！");
            }
        },
        error: function () {
            $.messager.alert("系统异常！");
        }
    });
}

//移除
function removeTopTen() {
    var selectedRows = $("#dg-table").datagrid('getSelections');
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请至少选择一条数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm("系统提示", "确认要移除吗？", function (r) {
        if (r) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: basePath + "/website/removeTopTen/" + ids,
                success: function (result) {
                    if (result.resultCode == 200) {
                        $.messager.alert("系统提示", "操作成功！");
                        $("#dg-table").datagrid("reload");
                    } else {
                        $.messager.alert("系统提示", "操作失败！");
                    }
                },
                error: function () {
                    $.messager.alert("系统异常！");
                }
            });
        }
    });
}