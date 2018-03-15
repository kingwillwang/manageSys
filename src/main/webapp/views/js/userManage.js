var baseUrl = basePath + "/users";
var method;

function searchUser() {
    $("#userTable").datagrid('load', {
        "userName": $("#s_userName").val()
    });
}

function openUserAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
    method = "POST";
}

function saveUser() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var data = {"password": password, "userName": userName}
    $.ajax({
        type: method,//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: baseUrl,//url
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (result) {
            console.log(result);//打印服务端返回的数据
            if (result.resultCode == 200) {
                $.messager.alert("系统提示", "保存成功");
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
                resetValue();
            } else {
                $.messager.alert("系统提示", "操作失败");
                $("#dlg").dialog("close");
                resetValue();
            }
        },
        error: function () {
            $.messager.alert("系统提示", "操作失败");
        }
    });
}

function openWatchUserDialog() {
    var selectedRows = $("#dg").datagrid('getSelections');
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

function resetValue() {
    $("#userName").val("");
    $("#password").val("");
}

function closeUserDialog() {
    $("#dlg").dialog("close");
    resetValue();
}
