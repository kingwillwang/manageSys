$(function () {
    //加载全部节点
    $('#websiteType').combotree({
        url: basePath + "/brandType/allTypeList",
        animate: true,
        lines: true,
        onlyLeafCheck: true,
        loadFilter: function (rows) {
            return convert(rows);
        }
    });
    $("#countNum").textbox('setValue', 0);

    $.ajaxFileUpload({
        type:'POST',
        url : basePath + "/upload/saveImg",
        secureuri : false,
        // data : queryFormParam('#formId'),//需要传递的数据 json格式
        fileElementId :'websiteLogoUp',
        dataType : 'json',
        success : function(data) { //上传成功后的回调。
            if(data.status){
                $.messager.alert("提示","保存成功");
            }else {
                $.messager.alert("提示","保存失败");
            }
        },
        error : function(data) {
            $.messager.alert("提示","异常，请稍后再试！");
        }
    });
});

//查询
function searchWebsite() {
    $("#dg-table").datagrid('load', {
        "websiteName": $("#s_websiteName").val()
    });
}

//打开对话框
function openAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle", "添加品牌");
}

//关闭对话框
function closeDialog() {
    $("#dlg").dialog("close");
    resetValue();
}

//获取节点树
function exists(rows, pid) {
    for (var i = 0; i < rows.length; i++) {
        if (rows[i].id == pid) return true;
    }
    return false;
}

function convert(rows) {
    var nodes = [];
    for (var j = 0; j < rows.length; j++) {
        var oneRow = rows[j];
        if (!exists(rows, oneRow.pid)) {
            nodes.push({
                id: oneRow.id,
                text: oneRow.typeName
            });
        }
    }

    var toDo = [];
    for (var k = 0; k < nodes.length; k++) {
        toDo.push(nodes[k]);
    }
    while (toDo.length) {
        var node = toDo.shift();    // the parent node
        // get the children nodes
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            if (row.pid == node.id) {
                var child = {id: row.id, text: row.typeName};
                if (node.children) {
                    node.children.push(child);
                } else {
                    node.children = [child];
                }
                toDo.push(child);
            }
        }
    }
    return nodes;
}

//重置
function resetValue() {
    $("#id").val("");
    $("#websiteName").textbox("clear");
    $("#websiteUrl").textbox('clear');
    $("#websiteLogo").val("");
    $('input:radio[name="isRecommend"][value="1"]').prop('checked', true);
    $("#websiteSort").combobox('clear');
    $("#countNum").textbox('setValue', 0);
    $("#websiteDesc").val("");
    $('#websiteType').combotree("clear");
}

//保存
function saveWebsite() {
    var id = $("#id").val();
    var websiteName = $("#websiteName").textbox("getValue");
    var websiteUrl = $("#websiteUrl").textbox("getValue");
    var websiteLogo = $("#websiteLogo").val();
    var isRecommend = $("input[name='isRecommend']:checked").val();
    var websiteSort = $("#websiteSort").combobox("getValue");
    var countNum = $("#countNum").textbox("getValue");
    var websiteDesc = $("#websiteDesc").val();
    var websiteTypeIds = $('#websiteType').combotree('getValues');

    var websiteTypeIdList = new Array();
    for (var i = 0; i < websiteTypeIds.length; i++) {
        websiteTypeIdList.push(websiteTypeIds[i]);
    }

    if (websiteName == null || websiteName == "" || typeof websiteName == "undefined") {
        $.messager.alert("系统提示", "名称不能为空！");
        resetValue();
    } else if (websiteTypeIds == null || websiteTypeIds == "" || typeof websiteTypeIds == "undefined") {
        $.messager.alert("系统提示", "类别不能为空！");
        resetValue();
    } else {
        var data = {
            "id": id,
            "websiteName": websiteName,
            "websiteLogo": websiteLogo,
            "websiteUrl": websiteUrl,
            "websiteSort": websiteSort,
            "isRecommend": isRecommend,
            "countNum": countNum,
            "websiteDesc": websiteDesc,
            "brandTypeIdList": websiteTypeIdList
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            url: basePath + "/website/addOrUpdate",
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
                    $("#dlg").dialog("close");
                    resetValue();
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
    $("#dlg").dialog("open").dialog("setTitle", "品牌信息");
    $('#fm').form('load', row);
    $("#id").val(row.id);
    $("#websiteSort").textbox('setValue', row.websiteSort);
    $('#websiteType').combotree('setValue', row.brandTypeIdList);
    $("#websiteDesc").val(row.websiteDesc);
}

//删除
function deleteWebsite() {
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
                url: basePath + "/website/" + ids,
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

