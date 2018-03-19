//查询
function searchLink() {
    $("#dg-table").datagrid('load', {
        "linkName": $("#s_linkName").val()
    });
}

//打开对话框
function openAddDialog() {
    $("#link-dlg").dialog("open").dialog("setTitle", "添加友情链接");
}

//重置
function resetValue() {
    $("#linkName").val("");
    $("#linkUrl").val("");
    $("#linkId").val("");
}

//关闭对话框
function closeDialog() {
    $("#link-dlg").dialog("close");
    resetValue();
}

//保存
function saveLink() {
    var linkName = $("#linkName").val();
    var linkUrl = $("#linkUrl").val();
    var linkId = $("#linkId").val();
    if (linkName == null || linkName == "" || typeof linkName == "undefined"
        || linkUrl == null || linkUrl == "" || typeof linkUrl == "undefined") {
        $.messager.alert("系统提示", "名称或地址不能为空！");
        resetValue();
    } else {
        var data = {
            "id" : linkId,
            "linkName": linkName,
            "linkUrl": linkUrl
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            url: basePath + "/friendlyLink/addOrUpdate",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
                    $.messager.alert("系统提示", "保存成功");
                    $("#link-dlg").dialog("close");
                    $("#dg-table").datagrid("reload");
                    resetValue();
                } else {
                    $.messager.alert("系统提示", result.message);
                    // $("#link-dlg").dialog("close");
                    // resetValue();
                }
            },
            error: function () {
                $.messager.alert("系统提示", "操作失败");
            }
        });
    }
}

//修改
function openModifyDialog() {
    var selectedRows = $("#dg-table").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#link-dlg").dialog("open").dialog("setTitle", "编辑友情链接");
    $('#fm').form('load', row);
    $("#linkId").val(row.id);
}

//删除
function deleteLinks() {
    var selectedRows = $("#dg-table").datagrid('getSelections');
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm("系统提示", "您确认要删除这<span style='color: red'>" + selectedRows.length + "</span>条数据吗？", function (r) {
        if (r) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: basePath + "/friendlyLink/" + ids,
                success: function (result) {
                    if (result.resultCode == 200) {
                        $.messager.alert("系统提示", "数据已成功删除！");
                        $("#dg-table").datagrid("reload");
                    } else {
                        $.messager.alert("系统提示", "数据删除失败！");
                    }
                },
                error: function () {
                    $.messager.alert("系统异常！");
                }
            });
        }
    });
}