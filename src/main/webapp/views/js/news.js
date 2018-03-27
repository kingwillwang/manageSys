$(function () {
    changeTxt();
    upImg();
    //详情编辑器
    KindEditor.ready(function (K) {
        this.editor = K.create('textarea[id="editor"]', {
            items: ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'multiimage',
                'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                'anchor', 'link', 'unlink'],
            uploadJson: basePath + '/upload/editorImg',
            fileManagerJson: basePath + '/upload/editorImg',
            filePostName: 'imgFile',
            allowFileManager: true
        });
    });
});

function changeTxt() {
    $('input[id=upFile]').change(function () {
        $('#photoCover').val($('input[id=upFile]').val());
    });
}

function upImg() {
    $("#uploadImg").click(function () {
        var text = $('#photoCover').val();
        if (text == null || text == "") {
            $.messager.alert("系统提示", "请选择文件！");
        } else {
            fileUpload("upFile");
            changeTxt();
        }
    });
}

function imageCheck(fileId) { //自己添加的文件后缀名的验证
    var img = document.getElementById(fileId);
    var imgName = img.value;
    var arr = ["jpg", "png", "JPG", "PNG"];
    var index = imgName.lastIndexOf(".");
    var ext = imgName.substr(index + 1);
    for (var i = 0; i < arr.length; i++) {
        if (ext == arr[i]) {
            return true;
            break;
        }
    }
    return false;
}

function fileUpload(fileId) {
    var id = $("#id").val();
    if (imageCheck(fileId)) { //文件后缀名的验证
        $.ajaxFileUpload({
            type: 'post',   //当要提交自定义参数时，这个参数要设置成post
            url: basePath + "/upload/saveNewsTitleImg", //后台方法的路径
            fileElementId: fileId,    //需要上传的文件域的ID，即<input type="file">的ID。
            data: {
                id: id
            },
            dataType: 'json',   //服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。
            secureuri: false,   //是否启用安全提交，默认为false。
            async: true,   //是否是异步
            success: function (result) {   //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
                if (result.resultCode == 200) {
                    $.messager.alert("系统提示", "上传成功");
                    $("#titleImg").val(result.data);
                } else {
                    $.messager.alert("系统提示", result.message);
                }
            },
            error: function () {  //提交失败自动执行的处理函数。
                $.messager.alert("系统提示", "操作失败");
            }
        });
    } else {
        $.messager.alert("系统提示", "图片格式仅支持jpg、png格式。");
    }
}

//查询
function searchNews() {
    $("#dg-table").datagrid('load', {
        "newsTitle": $("#s_newsTitle").val()
    });
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
                url: basePath + "/news/" + ids,
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

//打开对话框
function openAddDialog() {
    resetValue();
    $("#dlg").dialog("open").dialog("setTitle", "添加新闻");
}

//关闭对话框
function closeDialog() {
    $("#dlg").dialog("close");
    resetValue();
}

//重置
function resetValue() {
    $("#id").val("");
    $("#newsTitle").textbox("clear");
    $("#summary").val("");
    $("#titleImg").val("");
    $("#s_newsTitle").val("");
    editor.html();
}

//保存
function saveNews() {
    var id = $("#id").val();
    var newsTitle = $("#newsTitle").textbox("getValue");
    var summary = $("#summary").val();
    var titleImg = $("#titleImg").val();
    var content = editor.html();

    if (newsTitle == null || newsTitle == "" || typeof newsTitle == "undefined") {
        $.messager.alert("系统提示", "标题不能为空！");
    } else {
        var data = {
            "id": id,
            "newsTitle": newsTitle,
            "summary": summary,
            "titleImg": titleImg,
            "content": content
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            url: basePath + "/news/addOrUpdate",
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

//修改
function openModifyDialog() {
    var selectedRows = $("#dg-table").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "修改新闻");
    $('#fm').form('load', row);
    $("#id").val(row.id);
    editor.html(row.content);
}

function formatHref(val, row) {
    return "<a href='${pageContext.request.contextPath}/news.jsp?id=" + row.id + "' target='_blank'>查看详情</a>";
}