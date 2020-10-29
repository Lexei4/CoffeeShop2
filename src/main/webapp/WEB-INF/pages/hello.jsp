<%--
  Created by IntelliJ IDEA.
  User: Lexei4
  Date: 10/29/2020
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
</head>
<body>
${message}
<br>
<c:forEach var="str" items="${strings}">
    ${str}
    <br>
</c:forEach>
</body>
</html>
