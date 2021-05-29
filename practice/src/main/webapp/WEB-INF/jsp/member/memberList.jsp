<%--
  Created by IntelliJ IDEA.
  User: zuri
  Date: 2021-05-29
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MemberList</title>
</head>
<body>
<c:forEach items="${memberList}" var="list" varStatus="no">
    ${list.id},${list.name}
</c:forEach>
</body>
</html>