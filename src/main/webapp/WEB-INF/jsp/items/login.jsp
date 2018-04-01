<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2018/4/1
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<script type="text/javascript" src="/js/jquery.js"></script>
<head>
    <title>Title</title>
</head>
<%--<script type="text/javascript">--%>
    <%--function login() {--%>
        <%--$.ajax({--%>
            <%--type:'post',--%>
            <%--url:'${pageContext.request.contextPath}/user/login/hlq/123456',--%>
<%--//            contentType:'application/json;charset=utf-8',--%>
<%--//            data:"name=admin2&passwd=1234556",--%>
            <%--success:function (data) {--%>
                <%--alert(data);--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>
<body>
<form action="${pageContext.request.contextPath}/user/login.action" method="post" >
    姓名：<input type="text" name="username" id="username"><br>
    密码:<input type="password" name="passwd" id="passwd">
    <input type="submit" value="登入">
</form>
</body>
</html>
