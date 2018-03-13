<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
%>
<script>
    var BasePath = "<%=basePath%>";
</script>
<!-- 引入JQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/easyui-lang-zh_CN.js"></script>

<script src="${pageContext.request.contextPath}/js/common.js"></script>