function login() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    if (userName == null || userName == "") {
        alert("用户名不能为空！");
        return;
    }
    if (password == null || password == "") {
        alert("密码不能为空！");
        return;
    }
    $.ajax({
        type: "POST",
        dataType: "json",
        url: basePath + "/users/cookie",
        data: $("#adminlogin").serialize(),
        success: function (result) {
            if (result.resultCode == 200) {
                setCookie("userName", result.data.currentUser.userName);
                window.location.href = basePath + "/common/page/main.jsp";
            } else {
                alert(result.message);
            }
        },
        error: function () {
            alert("系统异常！");
        }
    });

}