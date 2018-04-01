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
        alert(1)
        alert(${pageContext.request.contextPath});
        document.forms[0].action="${pageContext.request.contextPath}/items/queryUser.action";
        document.forms[0].submit();
    }

    function editUserBatch() {

        document.forms[0].action="${pageContext.request.contextPath}/items/editUserBatch.action";
        document.forms[0].submit();
    }
</script>
<body>
<%--<form action="${pageContext.request.contextPath}/items/queryUser.action" method="post">--%>
<form>
    查询条件:
    <table border="1px">
        <tr>
            <td><input type="text" name="userCustomer.name" value=""></td>
            <td>
                <input type="button" value="查询" onclick="queryUser()">
                <input type="button" value="批量修改" onclick="editUserBatch()">
            </td>
        </tr>
        <tr>
            <td>name</td>
            <td>passwd</td>
            <td>detail</td>
        </tr>
        <c:forEach items="${requestScope.userList}" var="user" varStatus="status">
            <tr>

                <td><input type="text" name="userCustomerList[${status.index}].name" value="${user.name}"/></td>
                <td><input type="text" name="userCustomerList[${status.index}].passwd" value="${user.passwd}"></td>
                <td><input type="text" name="userCustomerList[${status.index}].detail" value="${user.detail}"></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
