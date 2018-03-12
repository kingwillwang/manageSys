var url = "${pageContext.request.contextPath}/users";
var method;

function searchUser() {
    $("#dg").datagrid('load', {
        "userName": $("#s_userName").val()
    });
}

function deleteUser() {
    var selectedRows = $("#dg").datagrid('getSelections');
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm("系统提示", "您确认要删除这<font color=red>"
        + selectedRows.length + "</font>条数据吗？", function (r) {
        if (r) {
            $.ajax({
                type: "DELETE",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/users/" + ids,//url
                data: {},
                success: function (result) {
                    console.log(result);//打印服务端返回的数据
                    if (result.resultCode == 200) {
                        $.messager.alert(
                            "系统提示",
                            "数据已成功删除！");
                        $("#dg").datagrid(
                            "reload");
                    }
                    else {
                        $.messager.alert(
                            "系统提示",
                            "数据删除失败！");
                    }

                    ;
                },
                error: function () {
                    $.messager.alert("ERROR！");
                }
            });
        }
    });

}

function openUserAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
    method = "POST";
}

function saveUser() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var id = $("#userId").val();
    var data = {"id": id, "password": password, "userName": userName}
    $.ajax({
        type: method,//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: url,//url
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (result) {
            console.log(result);//打印服务端返回的数据
            if (result.resultCode == 200) {
                $.messager.alert("系统提示", "保存成功");
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
                resetValue();
            }
            else {
                $.messager.alert("系统提示", "操作失败");
                $("#dlg").dialog("close");
                resetValue();
            }
            ;
        },
        error: function () {
            $.messager.alert("系统提示", "操作失败");
        }
    });
}

function openUserModifyDialog() {
    var selectedRows = $("#dg").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
    $('#fm').form('load', row);
    $("#password").val("******");
    $("#userId").val(row.id);
    method = "PUT";
}

function resetValue() {
    $("#userName").val("");
    $("#password").val("");
}

function closeUserDialog() {
    $("#dlg").dialog("close");
    resetValue();
}