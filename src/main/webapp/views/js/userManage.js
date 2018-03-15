var baseUrl = basePath + "/users";
$(document).ready(function () {
    //调用函数，初始化表格
    initTable();

});

//初始化
var userTable;
function initTable() {
    userTable = $("#userTable").bootstrapTable({
        method: "post",
        contentType : "application/x-www-form-urlencoded",
        url: baseUrl + "/datagrid",
        uniqueId: "id",
        // sidePagination: "server",
        // queryParamsType: "undefined",
        // queryParams: function queryParams(params) {   //设置查询参数
        //     var param = {
        //         pageNumber: params.pageNumber,
        //         pageSize: params.pageSize
        //     };
        //     return param;
        // },
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        formatNoMatches: function () {  //没有匹配的结果
            return '无符合条件的记录';
        },
        onLoadError: function (data) {
            alert("加载异常！！");
        }
    });
}
//刷新方法
$('#userRefresh').click(function () {
    userTable.bootstrapTable('refresh');
});

/* 行样式 */
function rowStyle(row, index) {
    var classes = ['active', 'success', 'info', 'warning', 'danger'];
    if (index % 2 != 0) {
        return {
            classes: ['info']
        }
    }
    return {};
}


// var method;
//
// function searchUser() {
//     $("#dg").datagrid('load', {
//         "userName": $("#s_userName").val()
//     });
// }
//
// function openUserAddDialog() {
//     $("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
//     method = "POST";
// }
//
// function saveUser() {
//     var userName = $("#userName").val();
//     var password = $("#password").val();
//     var data = {"password": password, "userName": userName}
//     $.ajax({
//         type: method,//方法类型
//         dataType: "json",//预期服务器返回的数据类型
//         url: url,//url
//         contentType: "application/json; charset=utf-8",
//         data: JSON.stringify(data),
//         success: function (result) {
//             console.log(result);//打印服务端返回的数据
//             if (result.resultCode == 200) {
//                 $.messager.alert("系统提示", "保存成功");
//                 $("#dlg").dialog("close");
//                 $("#dg").datagrid("reload");
//                 resetValue();
//             } else {
//                 $.messager.alert("系统提示", "操作失败");
//                 $("#dlg").dialog("close");
//                 resetValue();
//             }
//         },
//         error: function () {
//             $.messager.alert("系统提示", "操作失败");
//         }
//     });
// }
//
// function openWatchUserDialog() {
//     var selectedRows = $("#dg").datagrid('getSelections');
//     if (selectedRows.length != 1) {
//         $.messager.alert("系统提示", "请选择一条要查看的数据！");
//         return;
//     } else {
//         var row = selectedRows[0];
//         $('#win-detail').window('open');
//         // $('#fm').form('load', row);
//         // $("#password").val("******");
//         // $("#userId").val(row.id);
//         method = "PUT";
//     }
// }
//
// function resetValue() {
//     $("#userName").val("");
//     $("#password").val("");
// }
//
// function closeUserDialog() {
//     $("#dlg").dialog("close");
//     resetValue();
// }