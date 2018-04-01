<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2018/3/30
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <script src="js/jquery.js"></script>
    <title>Title</title>
</head>

<script type="text/javascript">
    function requestJson() {
        $.ajax({
            type:'post',
            url:'requestJson.action',
            contentType:'application/json;charset=utf-8',
            data:'{"name":"admin2","passwd":"1234556"}',
            success:function (data) {
                alert(data);
            }
        });
    }

    function reponseJson() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/responseJson.action',
//            contentType:'application/json;charset=utf-8',
            data:"name=admin2&passwd=1234556",
            success:function (data) {
                alert(data);
            }
        });
    }
</script>
<body>
<button type="button" onclick="requestJson()" >json请求</button>
<button type="button" onclick="reponseJson()" >key/value请求</button>

</body>
</html>
