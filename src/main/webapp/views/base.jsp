<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
%>
<script>
    var BasePath = "<%=basePath%>";
</script>

<script src="${pageContext.request.contextPath}/js/common.js"></script>