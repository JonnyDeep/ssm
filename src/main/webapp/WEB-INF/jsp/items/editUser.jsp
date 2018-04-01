<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2018/3/28
  Time: 18:33
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
<table border="1px">

    <c:if test="${requestScope.allErrors!=null}">
        <c:forEach items="${requestScope.allErrors}" var="error">
            ${error.defaultMessage}
        </c:forEach>
    </c:if>

   <form action="${pageContext.request.contextPath}/items/submitUser.action?id=${requestScope.userCustomer.iduser}" method="post" enctype="multipart/form-data">
       <input type="hidden" name="iduser" value="${userCustomer.iduser}"/>
       姓名:<input type="text" name="name"  value="${userCustomer.name}"/><br/>
       密码:<input type="password" name="passwd" value="${userCustomer.passwd}"/><br/>

      生日:<input type="text" placeholder="<fmt:formatDate value="${userCustomer.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>" name="birthday"><br/>
       <c:if test="${userCustomer.userpic !=null}">
           <img src="/pic/${userCustomer.userpic}" width=100 height=100/>
           <a href="/pic/${userCustomer.userpic}">图片</a>
           <input type="hidden" name="userpic" value="${userCustomer.userpic}">
           <br>
       </c:if>
       照片:<input type="file" name="user_pic"><br>
       详情:<textarea name="details" id="detailsid" cols="30" rows="10"></textarea><br>
       <input type="submit" value="提交"/>
   </form>

</table>
</body>
</html>

