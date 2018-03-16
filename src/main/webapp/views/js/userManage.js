var baseUrl = basePath + "/users";

//查询用户
function searchUser() {
    $("#userTable").datagrid('load', {
        "userName": $("#s_userName").val()
    });
}

//打开对话框
function openUserAddDialog() {
    $("#userAddDlg").dialog("open").dialog("setTitle", "添加用户");
}

//保存用户
function saveUser() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var data = {"password": password, "userName": userName};
    $.ajax({
        type: "POST",
        dataType: "json",
        url: baseUrl,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (result) {
            if (result.resultCode == 200) {
                $.messager.alert("系统提示", "保存成功");
                $("#userAddDlg").dialog("close");
                $("#userTable").datagrid("reload");
                resetValue();
            } else {
                $.messager.alert("系统提示", result.message);
                $("#userAddDlg").dialog("close");
                resetValue();
            }
        },
        error: function () {
            $.messager.alert("系统提示", "操作失败");
        }
    });
}

function openWatchUserDialog() {
    var selectedRows = $("#userTable").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要查看的数据！");
        return;
    } else {
        var row = selectedRows[0];
        $('#win-detail').window('open');
        // $('#fm').form('load', row);
        // $("#password").val("******");
        // $("#userId").val(row.id);
        method = "PUT";
    }
}

//重置
function resetValue() {
    $("#userName").val("");
    $("#password").val("");
}

//关闭对话框
function closeUserDialog() {
    $("#userAddDlg").dialog("close");
    resetValue();
}
