<%
    String path = request.getContextPath();
    String webPath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
%>
<script>
    var basePath = "<%=webPath%>";
</script>
<link rel="shortcut icon" href="#" />
<script src="${pageContext.request.contextPath}/common/js/common.js"></script>