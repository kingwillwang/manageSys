//查询
function searchFirstTypes() {
    $("#dg-table-first").datagrid('load', {
        "typeName": $("#s_typeName-first").val()
    });
}

//打开对话框
function openAddFirstType() {
    $("#dlg-first").dialog("open").dialog("setTitle", "添加一级分类");
}

//重置
function resetValue() {
    $("#typeId-first").val("");
    $("#typeName-first").val("");
    $("#s_typeName-first").val("");
    $("#s_typeName-second").val("");
    $("#typeId-second").val("");
    $("#typeName-second").val("");
}

//关闭对话框
function closeFirstDialog() {
    $("#dlg-first").dialog("close");
    resetValue();
}

//保存一级分类
function saveFirstBrandType() {
    var typeId = $("#typeId-first").val();
    var typeName = $("#typeName-first").val();
    if (typeName == null || typeName == "" || typeof typeName == "undefined") {
        $.messager.alert("系统提示", "名称不能为空！");
        resetValue();
    } else {
        var data = {
            "id": typeId,
            "typeName": typeName
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            url: basePath + "/brandType/addOrUpdateType",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
                    $.messager.alert("系统提示", "保存成功");
                    $("#dlg-first").dialog("close");
                    $("#dg-table-first").datagrid("reload");
                    resetValue();
                } else {
                    $.messager.alert("系统提示", result.message);
                    $("#dlg-first").dialog("close");
                    resetValue();
                }
            },
            error: function () {
                $.messager.alert("系统提示", "操作失败");
            }
        });
    }
}

//修改一级分类
function openModifyFirstType() {
    var selectedRows = $("#dg-table-first").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg-first").dialog("open").dialog("setTitle", "编辑类型信息");
    $('#fm-first').form('load', row);
    $("#typeId-first").val(row.id);
}

//查看二级分类
function openWatchSecondTypes() {
    var selectedRows = $("#dg-table-first").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要查看的数据！");
        return null;
    } else {
        resetValue();
        var row = selectedRows[0];
        $('#win-detail').window('open').window("setTitle", row.typeName);
        $("#pid").val(row.id);
        $('#detailTable').datagrid({
            url: basePath + "/brandType/secondTypeList",
            queryParams: {
                pid: row.id
            }
        });
    }
}

//二级查询
function searchSecondTypes() {
    $("#detailTable").datagrid('load', {
        "pid": $("#pid").val(),
        "typeName": $("#s_typeName-second").val()
    });
}

//打开二级对话框
function openAddSecondType() {
    $("#dlg-second").dialog("open").dialog("setTitle", "添加二级分类");
}

//关闭二级对话框
function closeSecondDialog() {
    $("#dlg-second").dialog("close");
    resetValue();
}

//保存二级分类
function saveSecondBrandType() {
    var typeId = $("#typeId-second").val();
    var typeName = $("#typeName-second").val();
    var pid = $("#pid").val();
    if (typeName == null || typeName == "" || typeof typeName == "undefined") {
        $.messager.alert("系统提示", "名称不能为空！");
        resetValue();
    } else {
        var data = {
            "id": typeId,
            "typeName": typeName,
            "pid": pid
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            url: basePath + "/brandType/addOrUpdateType",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
                    $.messager.alert("系统提示", "保存成功");
                    $("#dlg-second").dialog("close");
                    $("#detailTable").datagrid("reload");
                    resetValue();
                } else {
                    $.messager.alert("系统提示", result.message);
                    $("#dlg-second").dialog("close");
                    resetValue();
                }
            },
            error: function () {
                $.messager.alert("系统提示", "操作失败");
            }
        });
    }
}

//修改二级级分类
function openModifySecondType() {
    var selectedRows = $("#detailTable").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg-second").dialog("open").dialog("setTitle", "编辑类型信息");
    $('#fm-second').form('load', row);
    $("#typeId-second").val(row.id);
}

//删除二级分类
function deleteSecondType() {
    var selectedRows = $("#detailTable").datagrid('getSelections');
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm(
        "系统提示",
        "您确认要删除这<span style='color: red'>" + selectedRows.length + "</span>条数据吗？",
        function (r) {
            if (r) {
                $.ajax({
                    type: "DELETE",
                    dataType: "json",
                    url: basePath + "/brandType/deleteSecond/" + ids,
                    data: {},
                    success: function (result) {
                        if (result.resultCode == 200) {
                            $.messager.alert("系统提示","数据已成功删除！");
                            $("#detailTable").datagrid("reload");
                        } else {
                            $.messager.alert("系统提示","数据删除失败！");
                        }
                    },
                    error: function () {
                        $.messager.alert("系统异常！");
                    }
                });
            }
        });
}

//删除一级分类
function deleteFirstType() {
    var selectedRows = $("#dg-table-first").datagrid('getSelections');
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm("系统提示","<span style='color:red;'>删除这些记录时会删除对应子菜单的全部内容，确认删除吗？</span>",function(r) {
        if (r) {
            $.messager.confirm("系统提示", "确认要删除这<span style='color: red'>" + selectedRows.length + "</span>条数据吗？", function (r) {
                if (r) {
                    $.ajax({
                        type: "DELETE",
                        dataType: "json",
                        url: basePath + "/brandType/deleteFirst/" + ids,
                        success: function (result) {
                            if (result.resultCode == 200) {
                                $.messager.alert("系统提示", "数据已成功删除！");
                                $("#dg-table-first").datagrid("reload");
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
    });
}