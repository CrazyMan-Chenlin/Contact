<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.26
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:redirect url="/Contact">
    <c:param name="action" value="queryContact"/>
</c:redirect>
</body>
</html>
