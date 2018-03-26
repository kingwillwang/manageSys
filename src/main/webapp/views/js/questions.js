//重置
function resetValue() {
    $("#question").val("");
    $("#answer").val("");
    $("#questionId").val("");
    $("#s_question").val("");
}

//打开对话框
function openAddDialog() {
    resetValue();
    $("#dlg").dialog("open").dialog("setTitle", "添加问答");
}

//关闭对话框
function closeDialog() {
    $("#dlg").dialog("close");
    resetValue();
}

//查询
function searchQuestions() {
    $("#dg-table").datagrid('load', {
        "question": $("#s_question").val()
    });
}

//修改
function openModifyDialog() {
    var selectedRows = $("#dg-table").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑问答");
    $('#fm').form('load', row);
    $("#questionId").val(row.id);
}

//保存
function saveItem() {
    var question = $("#question").val();
    var answer = $("#answer").val();
    var questionId = $("#questionId").val();
    if (question == null || question == "" || typeof question == "undefined") {
        $.messager.alert("系统提示", "问题不能为空！");
        resetValue();
    } else {
        var data = {
            "id" : questionId,
            "question": question,
            "answer": answer
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            url: basePath + "/questions/addOrUpdate",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
                    $.messager.alert("系统提示", "保存成功");
                    $("#dlg").dialog("close");
                    $("#dg-table").datagrid("reload");
                    resetValue();
                } else {
                    $.messager.alert("系统提示", result.message);
                }
            },
            error: function () {
                $.messager.alert("系统提示", "操作失败");
            }
        });
    }
}

//删除
function deleteItems() {
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
                url: basePath + "/questions/" + ids,
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