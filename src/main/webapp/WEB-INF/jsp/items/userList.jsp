<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2018/3/28
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>

<script>
    function queryUser() {

        document.forms[0].action="${pageContext.request.contextPath}/items/queryUser.action";
        document.forms[0].submit();
    }

    function deleteUser() {
        document.forms[0].action="${pageContext.request.contextPath}/items/deleteUser.action";
        document.forms[0].submit();
    }
</script>
<body>

${username}
<c:if test="${username!=null}">
    ${username}
</c:if>
<%--<form action="${pageContext.request.contextPath}/items/queryUser.action" method="post">--%>
<form>
 查询条件:
<table border="1px">
    <tr>
        <td><input type="text" name="userCustomer.name" value=""></td>
        <td>
            <input type="button" value="查询" onclick="queryUser()">
            <input type="button" value="批量删除" onclick="deleteUser()">
        </td>
    </tr>
    <tr>
        <td>选择</td>
        <td>name</td>
        <td>passwd</td>
        <td>id</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.userList}" var="user">
        <tr>
            <td><input type="checkbox" name="user_id" value="${user.iduser}"></td>
            <td>${user.name}</td>
            <td>${user.passwd}</td>
            <td>${user.iduser}</td>
            <td><a href="${pageContext.request.contextPath}/items/editUser.action?id=${user.iduser}">修改</a> </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
