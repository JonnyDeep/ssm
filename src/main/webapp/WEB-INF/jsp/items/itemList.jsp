<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2018/3/27
  Time: 18:59
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
<body>
<c:if test="${username}！=null">
    ${username}
</c:if>
<table border="1px">
    <tr>
        <td>name</td>
        <td>price</td>
        <td>detail</td>
    </tr>
    <c:forEach items="${requestScope.itemsList}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.detail}</td>
        </tr>
    </c:forEach>

    <c:forEach items="${requestScope.userList}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.passwd}</td>
            <td>${user.idUser}</td>
        </tr>
    </c:forEach>
</table>
${name}
</body>
</html>
